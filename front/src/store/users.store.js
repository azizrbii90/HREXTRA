import { ListUsersService } from '@/services/users.service.js'
import { UpdateInfoUserService } from '@/services/user.service.js'

export default {

    state: {
        users: [],
    },

    getters: {
        getCurrentUsers(state) {
            return state.users
        },
    },

    mutations: {

        setCurrentUsers(state, users) {
            state.users = users
        },

        
        setCurrentUpdateUsers(state, user) {
            for (var i = 0; i < state.users.length; i++) {
                if (state.users[i].idUser == user.idUser) {
                    state.users[i] = user
                    break
                }
            }
        },
    },

    actions: {
        async ListUsers(context, idUser) {
            const response = await ListUsersService(idUser)
            context.commit('setCurrentUsers', response)
            return response
        },

        async UpdateUser(context, item) {
            const response = await UpdateInfoUserService(item);
            if(response.idUser) {
                context.commit("setCurrentUpdateUsers", response)
                return true
            }

            return false
        },
    }
}