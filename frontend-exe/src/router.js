import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    /*
    {
      path: "/",
      alias: "/tutorials",
      name: "tutorials",
      component: () => import("./components/TutorialsList")
    },*/
    {
      path: "/tutorials/:id",
      name: "tutorial-details",
      component: () => import("./components/Tutorial")
    },
    {
      path: "/add",
      name: "add",
      component: () => import("./components/AddTutorial")
    },    
     {
      path: "/",
      alias: "/ejercicios",
      name: "ejercicios",
      component: () => import("./components/ejercicios/EjerciciosList")
    },
    {
      path: "/ejercicios/:id",
      name: "ejercicio-details",
      component: () => import("./components/ejercicios/Ejercicio")
    },
    {
      path: "/addEjercicio",
      name: "addEjercicio",
      component: () => import("./components/ejercicios/AddEjercicio")
    },
    {
      path: "/addRegistroEj",
      name: "addRegistroEj",
      component: () => import("./components/ejercicios/AddRegistroEj")
    },    
    {
     path: "/registros",
     name: "registros",
     component: () => import("./components/ejercicios/RegistroList")
   }
  ]
});
