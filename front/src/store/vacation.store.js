import { AddVacationService, ListVacationsService, ListAllVacationsService, UpdateVacationService } from '@/services/vacation.service.js'

export default {

    state: {
        vacations: [],
        allVacations: [],
    },

    getters: {
        getCurrentVacations(state) {
            return state.vacations
        },
        getCurrentAllVacations(state) {
            return state.allVacations
        },
    },

    mutations: {

        setCurrentVacations(state, vacations) {
            state.vacations = vacations
        },

        setCurrentAllVacations(state, allVacations) {
            state.allVacations = allVacations
        },

        setCurrentAddVacation(state, vacation) {
            state.vacations.push(vacation)
        },

        setCurrentUpdateVacation(state, vacation) {
            for (var i = 0; i < state.vacations.length; i++) {
                if (state.vacations[i].id == vacation.id) {
                    state.vacations[i] = vacation
                    return
                }
            }

        },
    },

    actions: {
        async ListVacations(context, idUser) {
            const response = await ListVacationsService(idUser)
            context.commit('setCurrentVacations', response)
            return response
        },

        async ListAllVacations(context) {
            const response = await ListAllVacationsService()
            context.commit('setCurrentAllVacations', response)
            return response
        },

        async AddVacation(context, data) {
            let response = await AddVacationService(data)
            if (response.idConge) {
                context.commit('setCurrentAddVacation', response)
                return true
            }
            return false
        },

        async UpdateVacation(context, item) {
            let response = await UpdateVacationService(item)
            if (response.idConge) {
                context.commit('setCurrentUpdateVacation', response)
                return true
            }
            return false
        },
    }
}