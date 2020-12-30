pragma solidity ^0.5.6;

pragma experimental ABIEncoderV2;

import "./SafeMath.sol";
import "./Address.sol";
import "./Counters.sol";
import "./ERC165.sol";

contract NFTebrikler is ERC165 {

    using SafeMath for uint256;
    using Address for address;
    using Counters for Counters.Counter;

    event Transfer(address[] indexed from, address[] indexed to, uint256 indexed tokenId);
    event Approval(address[] indexed owner, address indexed approved, uint256 indexed tokenId);
    event MemoryRecorded(uint256 indexed tokendId, bytes photo, string title, string description, string location, uint256 memoryDate, uint256 recordDate);

    uint256[] private _allTokens;

    mapping (uint256 => address[]) private _tokenOwners;

    mapping (uint256 => address[]) private _tokenApprovals;

    mapping (address => uint256[]) private _ownedTokens;

    mapping (address => Counters.Counter) private _ownedTokensCount;

    mapping (uint256 => Memory) private _memoryList;

    struct MemoryFeed {
        uint256 tokenId;
        bytes photo;
    }
    
    struct Memory {
        uint256 tokenId;
        uint256 numberOfOwners;
        address[][] ownerHistory;
        bytes photo;
        string title;
        string description;
        string location;
        uint256 memoryDate;
        uint256 recordDate;
    }
    
    /*
     *     bytes4(keccak256('totalSupply()')) == 0x18160ddd
     *     bytes4(keccak256('balanceOf(address)')) == 0x70a08231
     *     bytes4(keccak256('ownerOf(uint256)')) == 0x6352211e
     *     bytes4(keccak256('approve(address,uint256)')) == 0x095ea7b3
     *     bytes4(keccak256('getApproved(uint256)')) == 0x081812fc
     *     bytes4(keccak256('transferOwnership(address[],uint256)')) == 0xb474b792
     *     bytes4(keccak256('recordMemory(address[],bytes,string,string,string,uint256)')) == 0xdc254d08
     *     bytes4(keccak256('getMemoryFeed(address)')) == 0xcbb57c7d
     *     bytes4(keccak256('getMemoryDetail(uint256)')) == 0x9eb492ee
     *     bytes4(keccak256('removeRecord(uint256)')) == 0x8693a683
     *
     *     => 0x18160ddd ^ 0x70a08231 ^ 0x6352211e ^ 0x095ea7b3 ^ 0x081812fc ^
     *        0xb474b792 ^ 0xdc254d08 ^ 0xcbb57c7d ^ 0x9eb492ee ^ 0x8693a683 == b161a937
     */
    bytes4 private constant _INTERFACE_ID_MEMORY = 0x80ac58cd;

    constructor() public {
        _registerInterface(_INTERFACE_ID_MEMORY);
    }

    function totalSupply() public view returns (uint256) {
        return _allTokens.length;
    }

    function balanceOf(address owner) public view returns (uint256) {
        require(owner != address(0), "Unvalid Address");

        return _ownedTokensCount[owner].current();
    }

    function ownerOf(uint256 tokenId) public view returns (address[] memory) {
        address[] memory owners = _tokenOwners[tokenId];
        for (uint i = 0; i < owners.length; i++) {
            require(owners[i] != address(0), "Unvalid Address");
        }

        return owners;
    }

    function approve(address to, uint256 tokenId) public {
        address[] memory owners = ownerOf(tokenId);
        bool isOwner = false;
        for (uint i = 0; i < owners.length; i++) {
            if (msg.sender == owners[i]) {
                isOwner = true;
            }
        }
        require(isOwner, "Not an Owner");

        for (uint i = 0; i < _tokenApprovals[tokenId].length; i++) {
            require(to != _tokenApprovals[tokenId][i], "Already Approved");
        }

        _tokenApprovals[tokenId].push(to);
        emit Approval(owners, to, tokenId);
    }

    function getApproved(uint256 tokenId) public view returns (address[] memory) {
        require(_exists(tokenId), "Not Exist Token");

        return _tokenApprovals[tokenId];
    }

    function transferOwnership(address[] memory to, uint256 tokenId) public {
        require(_isApprovedOrOwner(msg.sender, tokenId), "Not Approved Address");

        _transferFrom(to, tokenId);
    }

    function recordMemory(address[] memory owners, bytes memory photo, string memory title, string memory description, string memory location, uint256 memoryDate) public {
        uint256 tokenId = totalSupply() + 1;
        
        _mint(owners, tokenId);

        address[][] memory ownerHistory;

        Memory memory newMemory = Memory({
            tokenId: tokenId,
            numberOfOwners: owners.length,
            ownerHistory: ownerHistory,
            photo: photo,
            title: title,
            description: description,
            location: location,
            memoryDate: memoryDate,
            recordDate: now
        });

        _memoryList[tokenId] = newMemory;
        _memoryList[tokenId].ownerHistory.push(owners);

        emit MemoryRecorded(tokenId, photo, title, description, location, memoryDate, now);
    }

    function getMemoryFeed(address target) public view returns(MemoryFeed[] memory) {
        uint256 size = balanceOf(target);
        uint256[] memory owned = _ownedTokens[target];
        
        MemoryFeed[] memory result = new MemoryFeed[](size);
        for (uint i = 0; i < size; i++) {
            MemoryFeed memory tmp = MemoryFeed({
                tokenId: _memoryList[owned[i]].tokenId,
                photo: _memoryList[owned[i]].photo
            });
            result[i] = tmp;
        }
        return result;
    }

    function getMemoryDetail(uint256 tokenId) public view returns(Memory memory) {
        return _memoryList[tokenId];
    }

    function removeRecord(uint256 tokenId) public {
        require(_isOwner(msg.sender, tokenId), "Not an Owner");

        _burn(tokenId);
    }

    function _exists(uint256 tokenId) internal view returns (bool) {
        address[] memory owners = _tokenOwners[tokenId];

        if (owners.length == 0) {
            return false;
        }

        for (uint i = 0; i < owners.length; i ++) {
            if (owners[i] == address(0)) {
                return false;
            }
        }
        return true;
    }

    function _transferFrom(address[] memory to, uint256 tokenId) internal {
        address[] memory owners = ownerOf(tokenId);
        
        for (uint i = 0; i < to.length; i++) {
            require(to[i] != address(0), "Unvalid Address");
        }

        _clearApproval(tokenId);

        for (uint i = 0; i < owners.length; i++) {
            _ownedTokensCount[owners[i]].decrement();
        }
        for (uint i = 0; i < to.length; i++) {
            _ownedTokensCount[to[i]].increment();
        }

        _tokenOwners[tokenId] = to;
        _memoryList[tokenId].numberOfOwners = to.length;
        _memoryList[tokenId].ownerHistory.push(to);

        emit Transfer(owners, to, tokenId);
    }

    function _clearApproval(uint256 tokenId) private {
        _tokenApprovals[tokenId] = new address[](0);
    }

    function _isApproved(address spender, uint256 tokenId) internal view returns (bool) {
        require(_exists(tokenId), "Not Exist Token");

        address[] memory approveds = getApproved(tokenId);
        for (uint i = 0; i < approveds.length; i++) {
            if (spender == approveds[i]) {
                return true;
            }
        }
        
        return false;
    }

    function _isOwner(address spender, uint256 tokenId) internal view returns (bool) {
        require(_exists(tokenId), "Not Exist Token");

        address[] memory owners = ownerOf(tokenId);
        for (uint i = 0; i < owners.length; i++) {
            if (spender == owners[i]) {
                return true;
            }
        }
        
        return false;
    }

    function _isApprovedOrOwner(address spender, uint256 tokenId) internal view returns (bool) {
        require(_exists(tokenId), "Not Exist Token");

        return (_isApproved(spender, tokenId) || _isOwner(spender, tokenId)) ? true : false;
    }

    function _mint(address[] memory to, uint256 tokenId) internal {
        for (uint i = 0; i < to.length; i++) {
            require(to[i] != address(0), "Unvalid Address");
        }
        require(!_exists(tokenId), "Already Exist Token");

        _tokenOwners[tokenId] = to;
        for (uint i = 0; i < to.length; i++) {
            _ownedTokens[to[i]].push(tokenId);
            _ownedTokensCount[to[i]].increment();
        }

        _allTokens.push(tokenId);

        emit Transfer(new address[](0), to, tokenId);
    }

    function _burn(uint256 tokenId) internal {
        address[] memory owners = ownerOf(tokenId);

        for (uint i = 0; i < owners.length; i++) {
            _ownedTokensCount[owners[i]].decrement();
        }
        _tokenOwners[tokenId] = new address[](0);

        emit Transfer(owners, new address[](0), tokenId);
    }

}