import axios from 'axios'

const url = "http://localhost:8081"


export function ListUsersService() {
    return new Promise((resolve, reject) => {
        axios.get(url + `/users/`).then(response => {
            resolve(response.data)
        }).catch(err => reject(err))
    }) 
}