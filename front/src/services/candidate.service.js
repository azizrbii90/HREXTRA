import axios from 'axios'

const url = "http://localhost:8081"



export function AddCandidateService(formData) {
    var requestOptions = {
        method: 'POST',
        body: formData,
        redirect: 'follow'
    };
    return new Promise((resolve, reject) => {
        fetch(url + "/create-candidat", requestOptions)
        .then(response => {
            resolve(response.text())
        })
        .catch(error => resolve(error));
    })
}