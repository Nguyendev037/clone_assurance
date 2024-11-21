import React, { useEffect, useState } from "react";
import Table from "../components/Table.tsx";
import { Base_Axios } from "../axios.ts";

export default function LandingPage() {
  const [data, Setdata] = useState([]);

  const model = "products";

  const editFunction = (id: number) => {
    console.log("id component", id);
  };

//   const signedFunction = (id: number) => {};

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await Base_Axios.get(`/${model}`);
        console.log("API Response:", response.data);
        Setdata(response.data);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };
    fetchData();
  }, [model]);

  return (
    <>
      <Table
        model={model}
        data={data}
        buttons={[
          {
            actionName: "edit",
            action: editFunction,
          },
        ]}
      />
    </>
  );
}
