import axios from 'axios';


const Base_Axios = axios.create({
    baseURL: "http://localhost:8080/api"
})

export {Base_Axios};