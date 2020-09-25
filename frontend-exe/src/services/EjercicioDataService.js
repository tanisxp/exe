import http from "../http-common";

class EjercicioDataService {
  getAll() {
    return http.get("/ejercicios");
  }

  get(id) {
    return http.get(`/ejercicios/${id}`);
  }

  create(data) {
    return http.post("/newEjercicio", data);
  }

  update(id, data) {
    return http.put(`/ejercicios/${id}`, data);
  }

  delete(id) {
    return http.delete(`/ejercicios/${id}`);
  }

  deleteAll() {
    return http.delete(`/ejercicios`);
  }

  findByNombre(nombre) {
    return http.get(`/ejercicios?nombre=${nombre}`);
  }
}

export default new EjercicioDataService();
