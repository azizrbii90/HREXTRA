import axios from 'axios'

const url = "http://localhost:8081/api/auth"


export function RegisterService(data) {
    return new Promise((resolve, reject) => {
        axios.post(url + '/signup/', data).then(response => {
            resolve(response.data)
        }).catch(err => {
            resolve(err)
        })
    }) 
}

export function LoginService(data) {
    return new Promise((resolve, reject) => {
        axios.post(url + '/signin/', data).then(response => {
            resolve(response.data)
        }).catch(err => {
            resolve(err)
        })
    }) 
}

export async function GetInfo (token) {
    return new Promise((resolve, reject) => {
        axios.defaults.headers['Authorization'] = 'Bearer '+ token
        axios.get(url + '/getInfoFromToken/').then(response => {
            resolve(response.data)
        }).catch(err => reject(err))
    })
}



