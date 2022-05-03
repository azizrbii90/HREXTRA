import { AddPresenceService, UpdatePresenceService, ListPresencesService } from '@/services/presence.service.js'

export default {

    state: {
        presences: [],
    },

    getters: {
        getCurrentPresences(state) {
            return state.presences
        },
    },

    mutations: {

        setCurrentPresences(state, presences) {
            state.presences = presences
        },

        setCurrentAddPresence(state, presence) {
            state.presences.push(presence)
        },

        setCurrentUpdatePresence(state, presence) {
            for (var i = 0; i < state.presences.length; i++) {
                if (state.presences[i].id == presence.id) {
                    state.presences[i] = presence
                    return
                }
            }

        },
    },

    actions: {
        async ListPresences(context, idUser) {
            const response = await ListPresencesService(idUser)
            context.commit('setCurrentPresences', response)
            return response
        },

        async AddPresence(context, data) {
            let response = await AddPresenceService(data)
            if (response.idPresence) {
                context.commit('setCurrentAddPresence', response)
                return true
            }
            return false
        },

        async UpdatePresence(context, item) {
            let response = await UpdatePresenceService(item)
            if (response.idPresence) {
                context.commit('setCurrentUpdatePresence', response)
                return true
            }
            return false
        },
    }
}