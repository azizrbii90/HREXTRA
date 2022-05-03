import axios from 'axios'

const url = "http://localhost:8081"


export function ListPresencesService(idUser) {
    return new Promise((resolve, reject) => {
        axios.get(url + `/presences/user/`, {params : {id : idUser}}).then(response => {
            resolve(response.data)
        }).catch(err => reject(err))
    }) 
}

export function AddPresenceService(data) {
    return new Promise((resolve, reject) => {
        axios.post(url + `/presences/`, data.presence, {params : {id : data.idUser}}).then(response => {
            resolve(response.data)
        }).catch(err => {
            resolve(err)
        })
    }) 
}

export function UpdatePresenceService(presence) {
    return new Promise((resolve, reject) => {
        axios.put(url + `/presences/`, presence).then(response => {
            resolve(response.data)
        }).catch(err => {
            resolve(err)
        })
    }) 
}


