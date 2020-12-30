import React, { Component } from 'react'
import caver from 'klaytn/caver'
import Input from 'components/Input'
import Button from 'components/Button'
import Message from 'components/Message'
import FeeDelegation from 'components/FeeDelegation'
import BytecodeExample from 'components/BytecodeExample'

class SmartContractDeployFDRatio extends Component {
  constructor(props) {
    super(props)
    this.state = {
      from: props.from,
      data: '',
      value: 0,
      ratio: '',
      gas: 3000000,
      senderAddress: '',
      senderRawTransaction: null,
    }
  }

  static getDerivedStateFromProps = (nextProps, prevState) => {
    if (nextProps.from !== prevState.from) {
      return { from: nextProps.from }
    }
    return null
  }

  handleChange = (e) => {
    this.setState({
      [e.target.name]: e.target.value,
    })
  }

  signTransaction = async () => {
    const { from, data, value, ratio, gas } = this.state

    const txData = {
      type: 'FEE_DELEGATED_SMART_CONTRACT_DEPLOY_WITH_RATIO',
      from,
      data,
      value: caver.utils.toPeb(value.toString(), 'KLAY'),
      feeRatio: ratio,
      gas,
    }

    const { rawTransaction: senderRawTransaction } = await caver.klay.signTransaction(txData)

    this.setState({
      senderAddress: from,
      senderRawTransaction
    })
  }

  render() {
    const { from, data, value, ratio, gas, senderRawTransaction } = this.state

    return (
      <div className="SmartContractDeployFDRatio">
        <BytecodeExample />
        <h3>Sender</h3>
        <Input
          name="from"
          label="From (Sender Address)"
          value={from}
          placeholder="From Address"
          onChange={this.handleChange}
        />
        <Input
          name="data"
          label="Data (bytecode)"
          value={data}
          onChange={this.handleChange}
          placeholder="A bytecode of smart contract to be deployed."
        />
        <Input
          name="value"
          label="Value"
          value={value}
          onChange={this.handleChange}
          placeholder="Value (KLAY)"
        />
        <Input
          name="ratio"
          label="Fee Ratio"
          value={ratio}
          onChange={this.handleChange}
          placeholder="Fee Ratio (%)"
        />
        <Input
          name="gas"
          label="Gas"
          value={gas}
          onChange={this.handleChange}
          placeholder="Gas you willing to pay for contract deploy"
        />
        <Button
          title="Sign Transaction"
          onClick={this.signTransaction}
        />
        {senderRawTransaction && (
          <Message
            type="rawTransaction"
            message={JSON.stringify(senderRawTransaction)}
          />
        )}
        <FeeDelegation
          senderRawTransaction={senderRawTransaction}
          feePayerAddress={from}
        />
      </div>
    )
  }
}

export default SmartContractDeployFDRatio
