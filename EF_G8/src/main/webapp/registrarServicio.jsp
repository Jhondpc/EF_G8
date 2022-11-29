<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Registrar Servicio</title>
  </head>
  <body>
    <div class='container'>
      <div class="row justify-content-center mb-4">
        <div class="col-md-6">
          <h1 class='mb-3'>Registrar Servicio</h1>
          <form method="POST" action="<%=request.getContextPath()%>/ServicioServlet?action=crear">
            <div class="mb-3 form-group">
              <label>Selección local</label>
              <select required name="servicio" class="form-control">
                <option value="Impresión-3D">Impresión 3D</option>
                <option value="Corte-láser">Corte láser</option>
                <option value="Escaneo-Digital-3D">Escaneo Digital 3D</option>
              </select>
            </div>
            <div class="mb-3">
              <label class="form-label">Informacion</label>
              <input type="text" class="form-control" name="informacion">
            </div>
            <a href="<%= request.getContextPath()%>/ServicioServlet" class="btn btn-danger">Cancelar</a>
            <button type="submit" class="btn btn-primary">Registrar</button>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>