import React, { useState } from "react";
import { Base_Axios } from "../axios";
import { AxiosError } from "axios";
import Snackbar from "../components/Snackbar";

type FormState = {
  name: string;
  bankAccount: string;
  address: string;
  phone: string;
  email: string;
};

function SignIn() {
  const [form, setForm] = useState<FormState>({
    name: "",
    bankAccount: "",
    address: "",
    phone: "",
    email: "",
  });

  const [state, setState] = useState<string>("");
  const [open, setOpen] = useState<boolean>(false);

  async function handleSubmit(event: React.FormEvent<HTMLFormElement>) {
    event.preventDefault();
    try {
      const response = await Base_Axios.post("/user/create", form);
      if (response.status === 201) {
        setState("Sign in successfully");
      }
    } catch (error) {
      if (error instanceof AxiosError) {
        setState(`Error signing in: ${error.message || "Unknown error"}`);
      } else {
        setState("An unexpected error occurred");
      }
    }
    setOpen(true)
  }

  function handleChange(event: React.ChangeEvent<HTMLInputElement>) {
    const { name, value } = event.target;
    setForm((prevForm) => ({
      ...prevForm,
      [name]: value,
    }));
  }

  return (
    <>
      <form
        id="sign-in"
        className="modal-content animate"
        onSubmit={handleSubmit}
      >
        <div className="container">
          <label htmlFor="name">
            <b>Username</b>
          </label>
          <input
            type="text"
            placeholder="Enter Username"
            name="name"
            value={form.name}
            onChange={handleChange}
            required
          />
          
          <label htmlFor="bankAccount">
            <b>Bank Account</b>
          </label>
          <input
            type="text"
            placeholder="Enter Bank Account"
            name="bankAccount"
            value={form.bankAccount}
            onChange={handleChange}
            required
          />

          <label htmlFor="address">
            <b>Address</b>
          </label>
          <input
            type="text"
            placeholder="Enter Address"
            name="address"
            value={form.address}
            onChange={handleChange}
            required
          />

          <label htmlFor="phone">
            <b>Phone Number</b>
          </label>
          <input
            type="text"
            placeholder="Enter Phone Number"
            name="phone"
            value={form.phone}
            onChange={handleChange}
            required
          />

          <label htmlFor="email">
            <b>Email</b>
          </label>
          <input
            type="email"
            placeholder="Enter Email"
            name="email"
            value={form.email}
            onChange={handleChange}
            required
          />

          <button type="submit">Sign In</button>
        </div>
      </form>
      <Snackbar open={open} setOpen={setOpen} text={state}/>
    </>
  );
}

export default SignIn;
