import { createApp } from 'vue'
import App from './App.vue'
import router from '@/router/router';
import { library } from '@fortawesome/fontawesome-svg-core'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faLock, faEnvelope,faUser } from '@fortawesome/free-solid-svg-icons'

library.add(faLock,faEnvelope,faUser)


createApp(App).use(router).component('font-awesome-icon', FontAwesomeIcon).mount('#app');
