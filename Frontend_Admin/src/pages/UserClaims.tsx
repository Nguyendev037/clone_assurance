import React, {useEffect, useState} from 'react'
import Table from "../components/Table.tsx";
import {Base_Axios} from "../axios.ts";

function UserClaims() {
  const [data, setData] = useState([]); // Use camelCase for setter function
  const model = "claim";
  // Fetch Data
  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await Base_Axios.get(`/${model}`);
        console.log("API Response:", response.data);
        setData(response.data);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };
    fetchData();
  }, [model]);
  return (
    <div>
      <>
        <Table
            model={model}
            data={data}
            buttons={[
          
            ]}
        />
      </>
    </div>
  )
}

export default UserClaims
