
export default [{
  path: '/cms',
  component: () => import('@/module/home/page/home.vue'),
  name: 'CMS后台管理',
  hidden: false,
  iconCls: 'iconfont icon-cog',
  children: [
    {
      path: '/cms/page/list',
      name: '页面列表',
      component: () => import('@/module/cms/page/page_list.vue'),
      hidden: false,
      iconCls: 'iconfont icon-layer-group',
      meta: {parentName: 'CMS后台管理'}
    }
  ]
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
