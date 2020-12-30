import React from 'react'
import UploadButton from 'components/UploadButton'
import Feed from 'components/Feed'

import './CustomPage.scss'
const CustomPage = () => (
  <main className="CustomPage">
    <Feed />
    <UploadButton />
  </main>
)

export default CustomPage