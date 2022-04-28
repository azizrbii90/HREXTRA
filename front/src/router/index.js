import * as VueRouter from 'vue-router'

const LoginView = () => import("@/views/auth/login.vue")
const HomeView = () => import("@/views/home.vue")
const RegisterView = () => import("@/views/auth/register.vue")
const DashboardView = () => import("@/views/dashboard.vue")

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
            path: "/dashboard",
            name: "dashboard",
            component: DashboardView
        }

      ]
})

export default router;
