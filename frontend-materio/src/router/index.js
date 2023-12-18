import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/companies',
      component: () => import('../components/ui/CompanyGrid.vue'),
    },
    {
      path: '/products',
      component: () => import('../components/ui/ProductGrid.vue'),
    },
    {
      path: '/salesOrders',
      component: () => import('../components/ui/SalesOrderGrid.vue'),
    },
    {
      path: '/inventories',
      component: () => import('../components/ui/InventoryGrid.vue'),
    },
  ],
})

export default router;
