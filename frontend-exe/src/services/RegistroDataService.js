import http from "../http-common";

class RegistroDataService {
  getAll() {
    return http.get("/registros");
  }

  get(id) {
    return http.get(`/registros/${id}`);
  }

  create(data) {
    return http.post("/newRegistro", data);
  }

  update(id, data) {
    return http.put(`/registros/${id}`, data);
  }

  delete(id) {
    return http.delete(`/registros/${id}`);
  }

  deleteAll() {
    return http.delete(`/registros/deleteAll`);
  }

  findByNombre(nombre) {
    return http.get(`/registros?nombre=${nombre}`);
  }
}

export default new RegistroDataService();
