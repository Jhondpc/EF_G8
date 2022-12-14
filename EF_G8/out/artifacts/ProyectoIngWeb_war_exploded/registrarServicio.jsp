<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

  <head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Iniciar sesión</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="assets/img/favicon.png" rel="icon">
    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
    <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
    <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
    <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="assets/css/style_inicio_sesion.css" rel="stylesheet">

  <body>

    <main>
      <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

              <div class="card mb-3">

                <div class="card-body">

                  <div class="pt-4 pb-2">
                    <h5 class="card-title text-center pb-0 fs-4">Registra un Servicio</h5>
                  </div>

                  <form class="row g-3 needs-validation" method="POST" action="<%=request.getContextPath()%>/ServicioServlet?action=guardar">

                    <div class="col-12 form-group">
                      <label class="form-label" >Servicio</label>
                      <select required name="servicio" class="form-control">
                        <option value="Impresión-3D">Impresión 3D</option>
                        <option value="Corte-láser">Corte láser</option>
                        <option value="Escaneo-Digital-3D">Escaneo Digital 3D</option>
                      </select>
                    </div>

                    <div class="col-12">
                      <label class="form-label">Informacion</label>
                      <input type="text" class="form-control" name="informacion">
                      <div class="invalid-feedback">Ingresa la informacion!</div>
                    </div>
                    <% if (session.getAttribute("error") != null) { %>
                    <p class="text-danger small mb-0"><%=session.getAttribute("error")%></p>
                    <% session.removeAttribute("error");
                    } %>
                    <div class="col-6">
                      <button type="submit" class="btn btn-primary w-100" type="submit">Registrar</button>
                    </div>
                    <div class="col-6">
                      <a href="<%= request.getContextPath()%>/ServicioServlet" class="btn btn-danger">Cancelar</a>
                    </div>



                  </form>

                </div>
              </div>

            </div>
          </div>
        </div>
      </section>

      </div>
    </main><!-- End #main -->

    <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

    <!-- Vendor JS Files -->
    <script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="assets/vendor/chart.js/chart.min.js"></script>
    <script src="assets/vendor/echarts/echarts.min.js"></script>
    <script src="assets/vendor/quill/quill.min.js"></script>
    <script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
    <script src="assets/vendor/tinymce/tinymce.min.js"></script>
    <script src="assets/vendor/php-email-form/validate.js"></script>

    <!-- Template Main JS File -->
    <script src="assets/js/main.js"></script>

  </body>

</html>
