import { createRouter, createWebHistory } from 'vue-router';
import CalenderComponent from '@/components/CalenderComponent.vue';
import LoginPage from "@/views/LoginPage.vue";
import SpinnerComponent from "@/components/SpinnerComponent.vue";


const routes = [
    // Public routes (available to all users)
    { path: '/', name: 'LoginPage', component: LoginPage },
    {path:'/loader',name: 'SpinnerComponent', component: SpinnerComponent},
    { path: '/calendar', name: 'CalenderComponent', component: CalenderComponent },

];

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
});

export default router;
