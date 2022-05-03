import axios from 'axios'

const url = "http://localhost:8081"


export function ListVacationsService(idUser) {
    return new Promise((resolve, reject) => {
        axios.get(url + `/conges/user/${idUser}/`).then(response => {
            resolve(response.data)
        }).catch(err => reject(err))
    }) 
}


export function ListAllVacationsService() {
    return new Promise((resolve, reject) => {
        axios.get(url + `/conges/`).then(response => {
            resolve(response.data)
        }).catch(err => reject(err))
    }) 
}

export function AddVacationService(data) {
    return new Promise((resolve, reject) => {
        axios.post(url + `/createConge/`, data.vacation, {params : {id : data.idUser}}).then(response => {
            resolve(response.data)
        }).catch(err => {
            resolve(err)
        })
    }) 
}


export function UpdateVacationService(vacation) {
    return new Promise((resolve, reject) => {
        axios.put(url + `/updateConge/`, vacation).then(response => {
            resolve(response.data)
        }).catch(err => {
            resolve(err)
        })
    }) 
}

