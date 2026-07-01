import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from "../views/Index";
import AllCars from "../views/AllCars";
import ClientBooking from "../views/ClientBooking";
import OldClientBooking from "../views/OldClientBooking";
import AddBooking from "../views/AddBooking";
import AllAvailableCars from "../views/AllAvailableCars";
Vue.use(VueRouter)

const routes = [

  {
    path: '/',
    name: "Find a Car",
    component: Index,
    redirect:"/allCars",
    show:true,
    children:[
      { path: '/allCars',
        name: "All Cars",
        component: AllCars},
      { path: '/checkAvailable',
        name: "Check Available Cars",
        component: AllAvailableCars}
    ]
  },

  {
    path: '/ClientBooking',
    name: "Book a Car",
    component: Index,
    show:true,
    children:[
      { path: '/newUser',
        name: "New Users",
        component: ClientBooking},


  { path: '/oldUser',
    name: "Already have account",
    component: OldClientBooking},
      { path: '/addBooking',
        show:false,
        component: AddBooking},



    ]
  }



]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
