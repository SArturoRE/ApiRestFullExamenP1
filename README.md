<h1>Se implementaron los puntos del examen</h1>
<h3>En el registro de empleados se valido lo siguiente:</h3>

<ol>
  <li>El nombre y apellido del empleado no existan registrados en base de datos. </li>
  <li>Ser mayor de edad. </li>
  <li>El sexo asignado debe existir en la tabla de Genders. </li>
  <li>El puesto asignado debe existir en la tabla de Jobs. </li>
</ol>

<p>Se agrego una validacion que no se pedia, que es validar el id de empleado, se realizo por mera
practica y por costumbre<br> 
La ruta para realizar esa peticion es la siguiente: <br> http://localhost:9000/Examen/ws/empleados/registrarEmpleado
<br> Nota: se compara la edad con la fecha del dia en curso, asi que si un dato agregado cumple los 18 en este año pero en una fecha posterior a la que se esta transcurriendo
no registrara el usuario</p>

<h5>Registro de horas trabajadas</h5>
en las horas trabajadas se valido lo siguiente:
<ol>
  <li> El empleado debe estar registrado en la tabla de Employees</li>
</ol>

<p>Aqui tambien se valido el id<br> La ruta para la peticion es: http://localhost:9000/Examen/ws/horasTrabajadas/registrarHoras</p>
