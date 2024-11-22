import React, { useState } from 'react'
import Modal from '../components/Modal';
import CreateClaimForm from '../components/CreateClaimForm';

function UserClaims() {
    const [open,setOpen] = useState<boolean>(false);
    

    function createClaim(id : number){
        
    }

  return (
    <div>
      <Modal buttonText="accept claim" open={open} setOpen={setOpen} content={<CreateClaimForm />} />
    </div>
  )
}

export default UserClaims
