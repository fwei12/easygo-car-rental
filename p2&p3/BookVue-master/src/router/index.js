import Vue from 'vue'
import VueRouter from 'vue-router'
import BookUpdate from '../views/BookUpdate.vue'
import BookManage from '../views/BookManage'
import AddBooking from '../views/AddBooking'
import Index from "../views/Index";
import ClientManage from "../views/ClientManage";
import ClientManageById from "../views/ClientManageById";
import ClientUpdate from "../views/ClientUpdate";
import AddClient from "../views/AddClient";
import VehicleManage from "../views/VehicleManage";
import AddVehicle from "../views/AddVehicle";
import AddBill from "../views/AddBill";
import BillManage from "../views/BillManage";
import VehicleManageById from "../views/VehicleManageById";
import BookingManageById from "../views/BookingManageById";
import BookingManageByClientId from "../views/BookingManageByClientId";
import BookingManageByCarId from "../views/BookingManageByCarId";
import VehicleUpdate from "../views/VehicleUpdate";
import BillUpdate from "../views/BillUpdate";
import BillManageByBookingId from "../views/BillManageByBookingId";
Vue.use(VueRouter)

const routes = [

  {
    path: '/',
    name: "Booking Manage",
    component: Index,
    redirect:"/bookingManage",
    show:true,
    children:[
      {
        path: '/bookingManage',
        name: "All Bookings",
        component: BookManage
      },
      {
        path: '/addBooking',
        name: "Add a Booking",
        component: AddBooking
      },
    ]
  },



  {
    path: '/ClientManage',
    name: "Client Manage",
    component: Index,
    show:true,
    children:[
      {
        path: '/ClientManage',
        name: "All Clients",
        component: ClientManage
      },

      {
        path: '/addClient',
        name: "Add a Client",
        component: AddClient
      },

    ]
  },


  {
    path: '/vehicleManage',
    name: "Vehicle Manage",
    component: Index,
    show:true,
    children:[
      {
        path: '/vehicleManage',
        name: "All Vehicles",
        component: VehicleManage
      },

      {
        path: '/addVehicle',
        name: "Add a Vehicle",
        component: AddVehicle
      },

    ]
  },

  {
    path: '/billManage',
    name: "Bill Manage",
    component: Index,
    show:true,
    children:[
      {
        path: '/billManage',
        name: "All Bills",
        component: BillManage
      },

      {
        path: '/addBill',
        name: "Add a Bill",
        component: AddBill
      },

    ]
  },


  {
    path: '/update',
    show: false,
    component: BookUpdate
  },

  {
    path: '/ClientUpdate',
    show: false,
    component: ClientUpdate
  },

  {
    path: '/VehicleUpdate',
    show: false,
    component: VehicleUpdate
  },

  {
    path: '/BillUpdate',
    show: false,
    component: BillUpdate
  },
  {
    path: '/ClientManageById',
    show:false,
    component: ClientManageById
  },

  {
    path: '/vehicleManageById',
    show:false,
    component: VehicleManageById
  },

  {
    path: '/bookingManageById',
    show:false,
    component: BookingManageById
  },

  {
    path: '/bookingManageByClientId',
    show:false,
    component: BookingManageByClientId
  },

  {
    path: '/billManageByBookingId',
    show:false,
    component: BillManageByBookingId
  },

  {
    path: '/bookingManageByCarId',
    show:false,
    component: BookingManageByCarId
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
