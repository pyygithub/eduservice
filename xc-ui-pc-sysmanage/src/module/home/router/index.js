import Home from '@/module/home/page/home.vue';
export default [{
    path: '/',
    component: Home,
    name: 'Welcome',
    hidden: true
    // ,
    // redirect: '/home',
    // children: [
    //   {path: 'home', component: Home}
    // ]
  }/*,
  {
    path: '/login',
    component: Login,
    name: 'Login',
    hidden: true
  }*/
]
