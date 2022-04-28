import { RegisterService, LoginService, GetInfo } from '@/services/auth.service.js'

export default {
    state: {
        user: null, 
        auth : false
    },
    getters: {
        getCurrentUser(state) {
            return state.user
        },
        getCurrentAuth(state) {
            return state.auth
        }
    },
    mutations: {
        setCurrentUser(state, user) {
            state.user = user
        },
        setCurrentAuth(state,status) {
            state.auth = status
        }
    }, 
    actions: {

        async register(context,data) {
            const response = await RegisterService(data)
            return response
        },

        async login(context, data) {
            const response = await LoginService(data)
            if (response?.user?.username===data?.username) {
                localStorage.token = response.token
                context.commit('setCurrentUser', response.user)
                context.commit('setCurrentAuth', true)
                return true
            }
            return false
        },

        logout(context) {
            context.commit('setCurrentUser',null)
            context.commit('setCurrentAuth',false)
        },

        async getUserFromToken(context) {
            const user = await GetInfo(localStorage.token);
            if (user.idUser) {
                context.commit("setCurrentUser", user);
                context.commit("setCurrentAuth", true);   
            }
            return user;
          },
    }
}

