import Table from "../components/Table";
import Modal from "../components/Modal";
import ClaimForm from "../components/ClaimForm";
import { useEffect, useState } from "react";
import { Base_Axios } from "../axios";

function Claims() {
  const [data, Setdata] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await Base_Axios.get(`/claim`);
        console.log("API Response:", response.data);
        Setdata(response.data);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };
    fetchData();
  }, []);

  function editFunction(id: number) {
    console.log(data[id])
  }

  return (
    <div>
      <Table
        model="claims"
        data={data}
        buttons={[{ action: editFunction, actionName: "Accept" }]}
      />
      <Modal buttonText="accept claim" content={<ClaimForm />} />
    </div>
  );
}

export default Claims;
