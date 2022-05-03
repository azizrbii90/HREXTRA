import * as VueRouter from 'vue-router'

const LoginView = () => import("@/views/auth/login.vue")
const HomeView = () => import("@/views/home.vue")
const RegisterView = () => import("@/views/auth/register.vue")
const DashboardView = () => import("@/views/dashboard.vue")
const CandidateView = () => import("@/views/candidate/candidate.vue")
const VacationView = () => import("@/views/vacation/vacation.vue")
const LastVacationsView = () => import("@/views/vacation/lastVacations.vue")
const TimeTrackingView = () => import("@/views/time tracking/timeTracking.vue")
const InformationsView = () => import("@/views/profile/informations.vue")
const SettingsView = () => import("@/views/settings/settings.vue")
const ListUsersView = () => import("@/views/users/listUsers.vue")
const VacationsEmployeesReviewView = () => import("@/views/vacation/employeesReviews.vue")
const EmployeesVacationsView = () => import("@/views/vacation/employeesVacations.vue")

const router = VueRouter.createRouter({
    history: VueRouter.createWebHistory(),
    routes: [
        {
            path: "/",
            name: "home",
            component: HomeView
        } ,
        {
            path: "/sign-in",
            name: "sign-in",
            component: LoginView
        },
        {
            path: '/sign-up',
            name: "sign-up",
            component: RegisterView
        },
        {
            path: "/candidate",
            name: "candidate",
            component: CandidateView
        },
        {
            path: "/dashboard",
            name: "dashboard",
            redirect: "/vacations/new-request",
            component: DashboardView,
            children: [
              {
                path: '/vacations/new-request',
                name: 'vacation-request',
                component: VacationView
              },
              {
                path: '/vacations/last-requests',
                name: 'vacation-last-requests',
                component: LastVacationsView
              },
              {
                  path: '/time-tracking',
                  name: 'time-tracking',
                  component: TimeTrackingView
              },
              {
                path: '/profile',
                name: 'profile',
                component: InformationsView
            },
            {
                path: '/settings',
                name: 'settings',
                component: SettingsView
            },
            {
                path: '/employees/list/:type',
                name: 'employees-list',
                component: ListUsersView,
                props: true
            },
            {
                path: '/vacations/employees-reviews',
                name: 'vacations-employees-reviews',
                component: VacationsEmployeesReviewView,
            },
            {
                path: '/vacations/employees-requests',
                name: 'vacations-employees-requests',
                component: EmployeesVacationsView,
            }
            ]
        }
        /*
        {
            path: "/dashboard",
            name: "dashboard",
            component: DashboardView
        },*/

      ]
})

export default router;
