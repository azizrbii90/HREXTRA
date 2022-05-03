import axios from 'axios'

const url = "http://localhost:8081"


export function UpdateInfoUserService(user) {
    return new Promise((resolve, reject) => {
        axios.put(url + `/users/`, user).then(response => {
            resolve(response.data)
        }).catch(err => {
            resolve(err)
        })
    }) 
}

export function UpdateAvatarService(formData) {
    var myHeaders = new Headers();
    myHeaders.append("Authorization", "Bearer "+localStorage.getItem("token"));

    var requestOptions = {
        method: 'POST',
        body: formData,
        headers: myHeaders,
        redirect: 'follow'
    };
    return new Promise((resolve, reject) => {
        fetch(url + "/update-avatar", requestOptions)
        .then(response => {
            resolve(response.text())
        })
        .catch(error => resolve(error));
    })
}
