CREATE TABLE alumno (
    matricula varchar(9) PRIMARY KEY NOT NULL,
    nombre varchar(30) NOT NULL,
    paterno varchar(30) NOT NULL,
    materno varchar(30) NULL,
    telefono varchar(10) NOT NULL,
    correoPersonal varchar(100) NOT NULL,
    nombreContacto varchar(90) NOT NULL,
    correoContacto varchar(100) NOT NULL,
    telefonoContacto varchar(10) NOT NULL,
    promedio float NOT NULL,
    estado varchar(20) NOT NULL
);

CREATE TABLE servicioSocial (
    idserviciosocial int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    bloque int NOT NULL,
    seccion int NOT NULL,
    nrc int NOT NULL,
    periodo varchar(100) NOT NULL
);

CREATE TABLE inscripcion (
    idinscripcion int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    matriculaAlumno varchar(9) NOT NULL,
    FOREIGN KEY (matriculaAlumno) REFERENCES alumno(matricula),
    idserviciosocial int NOT NULL,
    FOREIGN KEY (idserviciosocial) REFERENCES servicioSocial(idserviciosocial),
    fecha date NOT NULL,
    tipo varchar(100) NOT NULL
);

CREATE TABLE historialAlumnoSS (
    idhistorial int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    idinscripcion int NOT NULL,
    FOREIGN KEY (idinscripcion) REFERENCES inscripcion(idinscripcion),
    fechaInicioSS date NOT NULL,
    fechaFinSS date NULL,
    horasAcumuladas int NOT NULL DEFAULT 0,
    numReportesEntregados int NOT NULL DEFAULT 0
);

CREATE TABLE unidadReceptora (
    idunidadreceptora int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre varchar(30) NOT NULL,
    correo varchar(30) NOT NULL,
    telefono varchar(10) NOT NULL,
    calle varchar(100) NOT NULL,
    numExt varchar(5) NOT NULL,
    colonia varchar(50) NOT NULL,
    codigoPostal varchar(5) NOT NULL
);

CREATE TABLE fechaEntregaReporte (
    identrega int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    fechaMinima date NOT NULL,
    fechaLimite date NOT NULL,
    mes varchar(10) NOT NULL
);

CREATE TABLE reporte (
    idreporte int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    idhistorial int NOT NULL,
    FOREIGN KEY (idhistorial) REFERENCES historialAlumnoSS(idhistorial),
    identrega int NOT NULL,
    FOREIGN KEY (identrega) REFERENCES fechaEntregaReporte(identrega),
    numero int NOT NULL,
    horasReportadas int NOT NULL,
    actividades varchar(255) NOT NULL,
    mes varchar(10) NOT NULL,
    fechaEntrega date NOT NULL,
    estado varchar(20) NOT NULL,
    motivoInvalidez varchar(100) NULL
);

CREATE TABLE archivo (
    idarchivo int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    idhistorial int NOT NULL,
    FOREIGN KEY (idhistorial) REFERENCES historialAlumnoSS(idhistorial),
    titulo varchar(150) NOT NULL,
    rutaUbicacion varchar(255) NOT NULL,
    estado varchar(20) NOT NULL,
    motivoInvalidez varchar(100) NULL
);

CREATE TABLE solicitud (
    idsolicitud int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    numAlumnos int NOT NULL DEFAULT 0,
    actividades varchar(255) NOT NULL,
    lugar varchar(100) NOT NULL,
    horario varchar(255) NOT NULL,
    responsableUnidad varchar(100) NOT NULL,
    requisitos varchar(255) NOT NULL,
    fechaRegistro date NOT NULL,
    idunidadreceptora int NOT NULL,
    FOREIGN KEY (idunidadreceptora) REFERENCES unidadReceptora (idunidadreceptora)
);

CREATE TABLE responsableProyecto (
    idresponsable int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre varchar(30) NOT NULL,
    paterno varchar(30) NOT NULL,
    materno varchar(30) NULL,
    correo varchar(100) NOT NULL,
    telefono varchar(10) NOT NULL
);

CREATE TABLE proyecto (
    idproyecto int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    idsolicitud int NOT NULL,
    FOREIGN KEY (idsolicitud) REFERENCES solicitud(idsolicitud),
    idresponsable int NOT NULL,
    FOREIGN KEY (idresponsable) REFERENCES responsableProyecto(idresponsable),
    nombre varchar(100) NOT NULL,
    descripcion varchar(255) NOT NULL,
    horarioAlumno varchar(255) NOT NULL,
    numAlumnos int NOT NULL DEFAULT 0,
    actividades varchar(255) NOT NULL,
    fechaRegistro date NOT NULL
);

CREATE TABLE solicitudAsignada (
    idhistorial int NOT NULL,
    FOREIGN KEY (idhistorial) REFERENCES historialAlumnoSS(idhistorial),
    idsolicitud int NOT NULL,
    FOREIGN KEY (idsolicitud) REFERENCES solicitud(idsolicitud)
);

CREATE TABLE proyectoAsignado (
    idhistorial int NOT NULL,
    FOREIGN KEY (idhistorial) REFERENCES historialAlumnoSS(idhistorial),
    idproyecto int NOT NULL,
    FOREIGN KEY (idproyecto) REFERENCES proyecto(idproyecto)
);

CREATE TABLE solicitudSeleccionada (
    idhistorial int NOT NULL,
    FOREIGN KEY (idhistorial) REFERENCES historialAlumnoSS(idhistorial),
    idsolicitud int NOT NULL,
    FOREIGN KEY (idsolicitud) REFERENCES solicitud(idsolicitud)
);
