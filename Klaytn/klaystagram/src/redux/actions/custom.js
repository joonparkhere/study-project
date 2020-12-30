const Caver = require('caver-js')
const caver = new Caver('https://api.baobab.klaytn.net:8651/')

const DEPLOYED_ABI = [
	{
		"constant": false,
		"inputs": [
			{
				"name": "to",
				"type": "address"
			},
			{
				"name": "tokenId",
				"type": "uint256"
			}
		],
		"name": "approve",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"constant": false,
		"inputs": [
			{
				"name": "owners",
				"type": "address[]"
			},
			{
				"name": "photo",
				"type": "bytes"
			},
			{
				"name": "title",
				"type": "string"
			},
			{
				"name": "description",
				"type": "string"
			},
			{
				"name": "location",
				"type": "string"
			},
			{
				"name": "memoryDate",
				"type": "uint256"
			}
		],
		"name": "recordMemory",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"constant": false,
		"inputs": [
			{
				"name": "tokenId",
				"type": "uint256"
			}
		],
		"name": "removeRecord",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"constant": false,
		"inputs": [
			{
				"name": "to",
				"type": "address[]"
			},
			{
				"name": "tokenId",
				"type": "uint256"
			}
		],
		"name": "transferOwnership",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"inputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "constructor"
	},
	{
		"anonymous": false,
		"inputs": [
			{
				"indexed": true,
				"name": "from",
				"type": "address[]"
			},
			{
				"indexed": true,
				"name": "to",
				"type": "address[]"
			},
			{
				"indexed": true,
				"name": "tokenId",
				"type": "uint256"
			}
		],
		"name": "Transfer",
		"type": "event"
	},
	{
		"anonymous": false,
		"inputs": [
			{
				"indexed": true,
				"name": "owner",
				"type": "address[]"
			},
			{
				"indexed": true,
				"name": "approved",
				"type": "address"
			},
			{
				"indexed": true,
				"name": "tokenId",
				"type": "uint256"
			}
		],
		"name": "Approval",
		"type": "event"
	},
	{
		"anonymous": false,
		"inputs": [
			{
				"indexed": true,
				"name": "tokendId",
				"type": "uint256"
			},
			{
				"indexed": false,
				"name": "photo",
				"type": "bytes"
			},
			{
				"indexed": false,
				"name": "title",
				"type": "string"
			},
			{
				"indexed": false,
				"name": "description",
				"type": "string"
			},
			{
				"indexed": false,
				"name": "location",
				"type": "string"
			},
			{
				"indexed": false,
				"name": "memoryDate",
				"type": "uint256"
			},
			{
				"indexed": false,
				"name": "recordDate",
				"type": "uint256"
			}
		],
		"name": "MemoryRecorded",
		"type": "event"
	},
	{
		"constant": true,
		"inputs": [
			{
				"name": "owner",
				"type": "address"
			}
		],
		"name": "balanceOf",
		"outputs": [
			{
				"name": "",
				"type": "uint256"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [
			{
				"name": "tokenId",
				"type": "uint256"
			}
		],
		"name": "getApproved",
		"outputs": [
			{
				"name": "",
				"type": "address[]"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [
			{
				"name": "tokenId",
				"type": "uint256"
			}
		],
		"name": "getMemoryBrief",
		"outputs": [
			{
				"name": "",
				"type": "uint256"
			},
			{
				"name": "",
				"type": "string"
			},
			{
				"name": "",
				"type": "string"
			},
			{
				"name": "",
				"type": "uint256"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [
			{
				"name": "tokenId",
				"type": "uint256"
			}
		],
		"name": "getMemoryDetail",
		"outputs": [
			{
				"name": "",
				"type": "uint256"
			},
			{
				"name": "",
				"type": "address[][]"
			},
			{
				"name": "",
				"type": "bytes"
			},
			{
				"name": "",
				"type": "string"
			},
			{
				"name": "",
				"type": "uint256"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [
			{
				"name": "tokenId",
				"type": "uint256"
			}
		],
		"name": "ownerOf",
		"outputs": [
			{
				"name": "",
				"type": "address[]"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [
			{
				"name": "interfaceId",
				"type": "bytes4"
			}
		],
		"name": "supportsInterface",
		"outputs": [
			{
				"name": "",
				"type": "bool"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [],
		"name": "totalSupply",
		"outputs": [
			{
				"name": "",
				"type": "uint256"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	}
]
const DEPLOYED_ADDRESS = '0x147Af8CE91BF7CA32aA4AA98Cb20E0d52336F9F5'

// console.log('----------------------------------------------------------------------------------------------------------')
// const address = caver.wallet.generate(1)[0]
// console.log(address)

// console.log('----------------------------------------------------------------------------------------------------------')
// const numberOfKeys = 3
// const keys = caver.wallet.keyring.generateMultipleKeys(numberOfKeys)
// console.log(keys)

// console.log('----------------------------------------------------------------------------------------------------------')
// const keyringSingle = caver.wallet.keyring.generate()
// console.log(keyringSingle)

// console.log('----------------------------------------------------------------------------------------------------------')
// const keyringMultiple = caver.wallet.keyring.create(address, keys)
// const keyringMultiple = caver.wallet.keyring.createWithMultipleKey(address, keys)
// console.log(keyringMultiple)
// caver.wallet.add(keyringMultiple)
// caver.wallet.updateKeyring(keyringMultiple)

// console.log('----------------------------------------------------------------------------------------------------------')
// caver.wallet.remove(address)
// const keyringMultipleWithAdd = caver.wallet.newKeyring(address, keys)
// console.log(keyringMultipleWithAdd)

// console.log('----------------------------------------------------------------------------------------------------------')
// const multiplePubKeys = keyringMultiple.getPublicKey()
// const singlePubkeys = keyringSingle.getPublicKey()
// console.log(multiplePubKeys)
// console.log(singlePubkeys)

// console.log('----------------------------------------------------------------------------------------------------------')
// const pw = 'tmdgh0221'
// const encryptedV4Multiple = keyringMultiple.encrypt(pw)
// const keystoreV4Multiple = JSON.stringify(encryptedV4Multiple)
// console.log(keystoreV4Multiple)
// const encryptedV4Single = keyringSingle.encrypt(pw)
// const keystoreV4Single = JSON.stringify(encryptedV4Single)
// console.log(keystoreV4Single)
// const encryptedV3 = keyringSingle.encryptV3(pw)
// const keystoreV3 = JSON.stringify(encryptedV3)
// console.log(keystoreV3)

// console.log('----------------------------------------------------------------------------------------------------------')
// const decryptedKeystoreMultiple = caver.wallet.keyring.decrypt(keystoreMulitple, pw)
// console.log(decryptedKeystoreMultiple)

// console.log('----------------------------------------------------------------------------------------------------------')
// console.log(caver.wallet._addressKeyringMap)

// console.log('----------------------------------------------------------------------------------------------------------')
// const accountMultiple = caver.account.create(address, multiplePubKeys)
// const accountMultiple = caver.account.createWithAccountKeyWeightedMultiSig(address, multiplePubKeys)
// console.log(accountMultiple)

// console.log('----------------------------------------------------------------------------------------------------------')
// const myAddress = '0x4729c7d6E30bB6f50E3b0A0d48C925B4d22Af360'
// console.log(caver.utils.isAddress(myAddress))
const myKey = '0xaf4760b536e8f959fa7fea3edde4332c0e2812296ef33f3e492a0fdb731341b7'
// const myKeyring = caver.wallet.keyring.create(myAddress, myKey)
// caver.wallet.add(myKeyring)
// const myPubkey = myKeyring.getPublicKey()
// const myAccount = caver.account.createWithAccountKeyPublic(myAddress, myPubkey)
// console.log(myAccount)
// console.log(caver.wallet._addressKeyringMap)

console.log('----------------------------------------------------------------------------------------------------------')
const walletInstance = caver.klay.accounts.privateKeyToAccount(myKey)
caver.klay.accounts.wallet.add(walletInstance)
// console.log(caver.klay.accounts.wallet.length)
const myWallet = caver.klay.accounts.wallet[0]
// console.log(myWallet.address)

console.log('----------------------------------------------------------------------------------------------------------')
const myContract = new caver.klay.Contract(DEPLOYED_ABI, DEPLOYED_ADDRESS)
// totalSupply()
// getMemoryDetail(7)
async function totalSupply() {
    let value;
    await myContract.methods.totalSupply().call().then((result) => value = result)
    console.log('>>totalSupply')
    console.log(value)
}
async function getMemoryDetail(tokenId) {
    let value;
    await myContract.methods.getMemoryDetail(tokenId).call().then((result) => value = result)
    console.log('>>getMemoryDetail')
    console.log(value)
}
// const owners = ['0x4729c7d6E30bB6f50E3b0A0d48C925B4d22Af360']
// const photo = caver.utils.hexToBytes('0x11')
// const title = '11'
// const description = '11'
// const location = '11'
// const memoryDate = 11
// myContract.methods.recordMemory(owners, photo, title, description, location, memoryDate).send({
//     from: myWallet.address,
//     gas: '30000000'
// })
//     .once('MemoryRecorded', function(event) {
//         console.log('>>MemoryRecorded')
//         console.log(event)
//     })
//     .once('transactionHash', function(hash) {
//         console.log('>>transactionHash')
//         console.log(hash)
//     })
//     .once('receipt', function(receipt) {
//         console.log('>>receipt')
//         console.log(receipt)
//     })
//     .once('error', function(error) {
//         console.log('>>error')
//         console.log(error)
//     })
// const to = ['0xe661B50Ecda9608494E4bdfdcD999A0F26bD4503']
// const transferTokenId = 8
// myContract.methods.transferOwnership(to, transferTokenId).send({
//     from: myWallet.address,
//     gas: '30000000'
// })
//     .once('MemoryRecorded', function(event) {
//         console.log('>>MemoryRecorded')
//         console.log(event)
//     })
//     .once('transactionHash', function(hash) {
//         console.log('>>transactionHash')
//         console.log(hash)
//     })
//     .once('receipt', function(receipt) {
//         console.log('>>receipt')
//         console.log(receipt)
//     })
//     .once('error', function(error) {
//         console.log('>>error')
//         console.log(error)
//     })
// myContract.once('MemoryRecorded', function(error, event) {
//     console.log('>>onceTest')
//     if (error) console.log(error)
//     else console.log(event)
// })
// myContract.getPastEvents('MemoryRecorded', function(error, events) {
//     console.log('>>getPastEvents')
//     if (error) console.log(error)
//     else console.log(events)
// })

import ui from 'utils/ui'

export const recordMemory = (
    file,
    fileName,
    location,
    caption
) => (dispatch) => {
    const reader = new window.FileReader()
    reader.readAsArrayBuffer(file)
    reader.onloadend = () => {
        const buffer = Buffer.from(reader.result)
        /**
         * Add prefix `0x` to hexString
         * to recognize hexString as bytes by contract
         */
        const hexString = "0x" + buffer.toString('hex')
        // FROM HERE
        const owners = ['0x4729c7d6E30bB6f50E3b0A0d48C925B4d22Af360']
        // const photo = caver.utils.hexToBytes('0x11')
        const title = '11'
        const description = '11'
        const location = '11'
        const memoryDate = 11
        myContract.methods.recordMemory(owners, hexString, title, description, location, memoryDate).send({
            from: myWallet.address,
            gas: '30000000'
        })
            .once('MemoryRecorded', function(event) {
                console.log('>>MemoryRecorded')
                console.log(event)
            })
            .once('transactionHash', function(hash) {
                console.log('>>transactionHash')
                console.log(hash)
                ui.showToast({
                    status: 'pending',
                    message: `Sending a transaction... (uploadPhoto)`,
                    hash,
                })
            })
            .once('receipt', function(receipt) {
                console.log('>>receipt')
                console.log(receipt)
                ui.showToast({
                    status: receipt.status ? 'success' : 'fail',
                    message: `Received receipt! It means your transaction is
                    in klaytn block (#${receipt.blockNumber}) (uploadPhoto)`,
                    link: receipt.transactionHash,
                })
            })
            .once('error', function(error) {
                console.log('>>error')
                console.log(error)
            })
        // TO HERE
        // KlaystagramContract.methods.uploadPhoto(hexString, fileName, location, caption).send({
        //     from: getWallet().address,
        //     gas: '200000000',
        // })
        //     .once('transactionHash', (txHash) => {
        //     console.log('>>transactionHash')
        //     console.log(txHash)
        //     ui.showToast({
        //         status: 'pending',
        //         message: `Sending a transaction... (uploadPhoto)`,
        //         txHash,
        //     })
        //     })
        //     .once('receipt', (receipt) => {
        //     console.log('>>receipt')
        //     console.log(receipt)
        //     ui.showToast({
        //         status: receipt.status ? 'success' : 'fail',
        //         message: `Received receipt! It means your transaction is
        //         in klaytn block (#${receipt.blockNumber}) (uploadPhoto)`,
        //         link: receipt.transactionHash,
        //     })
        //     const tokenId = receipt.events.PhotoUploaded.returnValues[0]
        //     dispatch(updateFeed(tokenId))
        //     })
        //     .once('error', (error) => {
        //     console.log('>>error')
        //     console.log(error)
        //     ui.showToast({
        //         status: 'error',
        //         message: error.toString(),
        //     })
        //     })
    }
  }