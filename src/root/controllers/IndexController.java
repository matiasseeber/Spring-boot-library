package root.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.omg.CORBA.NO_MEMORY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import root.bussinesImp.NegAutorImpl;
import root.bussinesImp.NegBibliotecaImpl;
import root.bussinesImp.NegClientesImpl;
import root.bussinesImp.NegGeneroImpl;
import root.bussinesImp.NegLibrosImpl;
import root.bussinesImp.NegNacionalidadImpl;
import root.bussinesImp.NegPrestamosImpl;
import root.bussinesImp.NegUsuariosImpl;
import root.entities.Autor;
import root.entities.Biblioteca;
import root.entities.Clientes;
import root.entities.Genero;
import root.entities.Libro;
import root.entities.Nacionalidad;
import root.entities.Prestamos;
import root.entities.Usuarios;

@Controller
public class IndexController {

	@Autowired
	NegUsuariosImpl negUsuarios;

	@Autowired
	NegNacionalidadImpl negNacionalidad;

	@Autowired
	NegAutorImpl negAutorImpl;

	@Autowired
	NegGeneroImpl NegGeneroImpl;

	@Autowired
	NegClientesImpl negClientesImpl;

	@Autowired
	NegLibrosImpl negLibrosImpl;

	@Autowired
	NegBibliotecaImpl negBibliotecaImpl;

	@Autowired
	NegPrestamosImpl negPrestamosImpl;

	@Autowired
	Usuarios user;

	@Autowired
	Nacionalidad nacionalidad;

	@Autowired
	Libro libro;

	@Autowired
	Autor autor;

	@Autowired
	Genero genero;

	@Autowired
	Clientes cliente;

	@Autowired
	Biblioteca biblioteca;

	@Autowired
	Prestamos prestamo;

	private boolean wasDataInserted = false;

	private String nombreUsuario = "";

	@RequestMapping("index.html")
	public ModelAndView eventoCargarLogin() {
		System.out.println("mapping index.html");
		nombreUsuario = "";
		if (!wasDataInserted) {
			try {

				user.setEmail("matias@gmail.com");
				user.setPassword("123");
				user.setUsername("matias");
				negUsuarios.addUser(user);

				nacionalidad.setDescripcion("Argentina");
				negNacionalidad.addNationality(nacionalidad);

				autor.setNombre("pepe");
				autor.setApellido("casas");
				autor.setEmail("pepe@gmail.com");
				autor.setNacionalidad(nacionalidad);
				negAutorImpl.addWritter(autor);

				autor.setNombre("roberto");
				autor.setApellido("perez");
				autor.setEmail("roberto@gmail.com");
				negAutorImpl.addWritter(autor);

				Date dateFormat;
				
				libro.setAutor(autor);
				libro.setCantidadPaginas(1020);
				libro.setDescripcion("El Señor de los Anillos");
				dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse("2005-05-04");
				libro.setFechaLanzamiento(dateFormat);
				
				genero.setDescripcion("Romance");
				NegGeneroImpl.addGenre(genero);

				HashSet<Genero> generos = new HashSet<>();
				generos.add(genero);
				libro.setGeneros(generos);
				libro.setIdioma("Ingles");
				libro.setISBN(1011);
				libro.setTitulo("El Señor de los Anillos");

				negLibrosImpl.addBook(libro);
				
				autor.setNombre("Julian");
                autor.setApellido("Martinez");
                autor.setEmail("Martinez@gmail.com");
                nacionalidad.setDescripcion("Chile");
                negNacionalidad.addNationality(nacionalidad);
                autor.setNacionalidad(nacionalidad);
                negAutorImpl.addWritter(autor);

                autor.setNombre("Roberto");
                autor.setApellido("Dolores");
                autor.setEmail("DRoberto@gmail.com");
                autor.setNacionalidad(nacionalidad);
                negAutorImpl.addWritter(autor);

                autor.setNombre("Maria");
                autor.setApellido("Alvarez");
                autor.setEmail("AlvMaria@gmail.com");
                nacionalidad.setDescripcion("Francia");
                negNacionalidad.addNationality(nacionalidad);
                autor.setNacionalidad(nacionalidad);
                negAutorImpl.addWritter(autor);

				
                nacionalidad.setDescripcion("Bolivia");
                negNacionalidad.addNationality(nacionalidad);
                autor.setNombre("Jaime");
                autor.setApellido("Nisttahuz");
                autor.setEmail("jnisttahuz@gmail.com");
                autor.setNacionalidad(nacionalidad);
                negAutorImpl.addWritter(autor);


                nacionalidad.setDescripcion("Afganistan");
                negNacionalidad.addNationality(nacionalidad);
                autor.setNombre("Abdul");
                autor.setApellido("Habibi");
                autor.setEmail("ahabibi@gmail.com");
                autor.setNacionalidad(nacionalidad);
                negAutorImpl.addWritter(autor);


                nacionalidad.setDescripcion("Rusia");
                negNacionalidad.addNationality(nacionalidad);
                autor.setNombre("Vladimir");
                autor.setApellido("Nabokov");
                autor.setEmail("vnabokov@gmail.com");
                autor.setNacionalidad(nacionalidad);
                negAutorImpl.addWritter(autor);

				genero.setDescripcion("Horror");
				NegGeneroImpl.addGenre(genero);
				generos = new HashSet<>();
                generos.add(genero);
                libro.setGeneros(generos);
                libro.setIdioma("Español");
                libro.setISBN(4588);
                libro.setTitulo("Don Quijote y Sancho Panza");
                negLibrosImpl.addBook(libro);
				genero.setDescripcion("Comedia");
				NegGeneroImpl.addGenre(genero);
				genero.setDescripcion("Drama");
				NegGeneroImpl.addGenre(genero);
				generos = new HashSet<>();
                generos.add(genero);
                libro.setGeneros(generos);
                libro.setIdioma("Español");
                libro.setISBN(777);
                libro.setTitulo("Marley y Yo");
                negLibrosImpl.addBook(libro);
				genero.setDescripcion("Accion");
				NegGeneroImpl.addGenre(genero);

				cliente.setNombre("Marta");
                cliente.setApellido("Mieles");
                cliente.setDireccion("Liebres 111");
                cliente.setDni(458787);
                cliente.setEmail("MielesM@gmail.com");
                cliente.setLocalidad("Quilmes");

                dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse("2002-07-05");
                cliente.setFechaNacimiento(dateFormat);
                cliente.setNacionalidad(nacionalidad);
                cliente.setTelefono(11254555);
                cliente.setSexo("Femenino");
                negClientesImpl.AddClient(cliente);

                nacionalidad.setDescripcion("Corea del Norte");
                negNacionalidad.addNationality(nacionalidad);
                autor.setNombre("Kim");
                autor.setApellido("Tubong");
                autor.setEmail("ktubong@gmail.com");
                autor.setNacionalidad(nacionalidad);
                negAutorImpl.addWritter(autor);
                
                nacionalidad.setDescripcion("Mexico");
                negNacionalidad.addNationality(nacionalidad);

				cliente.setNombre("Pepe");
				cliente.setApellido("Perez");
				cliente.setDireccion("ruta 197");
				cliente.setDni(123);
				cliente.setEmail("pepe@gmail.com");
				cliente.setLocalidad("Tigre");
				
				dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-01");
				cliente.setFechaNacimiento(dateFormat);
				cliente.setNacionalidad(nacionalidad);
				cliente.setTelefono(123);
				cliente.setSexo("Masculino");
				negClientesImpl.AddClient(cliente);

				nacionalidad.setDescripcion("SudAfrica");
                negNacionalidad.addNationality(nacionalidad);
                autor.setNombre("Shadreck ");
                autor.setApellido("Chikoti");
                autor.setEmail("schikoti@gmail.com");
                autor.setNacionalidad(nacionalidad);
                negAutorImpl.addWritter(autor);
				
                libro.setAutor(autor);
                libro.setCantidadPaginas(200);
                libro.setDescripcion("Acompaña a La Rosa de Guadalupe");
                dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse("1900-10-20");
                libro.setFechaLanzamiento(dateFormat);

                generos = new HashSet<>();
                generos.add(genero);
                libro.setGeneros(generos);
                libro.setIdioma("Portugues");
                libro.setISBN(5997);
                libro.setTitulo("La Rosa de Guadalupe");
                negLibrosImpl.addBook(libro);
                
				cliente.setNombre("Julio");
                cliente.setApellido("Altes");
                cliente.setDireccion("Calle 87");
                cliente.setDni(205454);
                cliente.setEmail("AltesJulio@gmail.com");
                cliente.setLocalidad("Chacarita");

                dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse("1995-11-20");
                cliente.setFechaNacimiento(dateFormat);
                cliente.setNacionalidad(nacionalidad);
                cliente.setTelefono(1154878);
                cliente.setSexo("Masculino");
                negClientesImpl.AddClient(cliente);

                cliente.setNombre("Natalia");
                cliente.setApellido("Lita");
                cliente.setDireccion("Mitre 8887");
                cliente.setDni(3545454);
                cliente.setEmail("LitaN@gmail.com");
                cliente.setLocalidad("San Isidro");
                
                dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse("1998-05-02");
                cliente.setFechaNacimiento(dateFormat);
                cliente.setNacionalidad(nacionalidad);
                cliente.setTelefono(1154878);
                cliente.setSexo("Masculino");
                negClientesImpl.AddClient(cliente);

                autor.setNombre("Simona");
                autor.setApellido("Juarez");
                autor.setEmail("JuarezS@gmail.com");
                nacionalidad.setDescripcion("Peru");
                negNacionalidad.addNationality(nacionalidad);
                autor.setNacionalidad(nacionalidad);
                negAutorImpl.addWritter(autor);
                
                autor.setNombre("Juan");
                autor.setApellido("gabriel");
                autor.setEmail("jgabriel@gmail.com");
                nacionalidad.setDescripcion("Bolivia");
                negNacionalidad.addNationality(nacionalidad);
                autor.setNacionalidad(nacionalidad);
                negAutorImpl.addWritter(autor);

                libro.setAutor(autor);
                libro.setCantidadPaginas(250);
                libro.setTitulo("Resident evil 4");
                dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse("2000-05-20");
                libro.setFechaLanzamiento(dateFormat);

                generos = new HashSet<>();
                generos.add(genero);
                libro.setGeneros(generos);
                libro.setIdioma("Hebreo");
                libro.setISBN(4588);
                libro.setDescripcion("Historia de Zombies");
                negLibrosImpl.addBook(libro);

                libro.setAutor(autor);
                libro.setCantidadPaginas(250);
                libro.setDescripcion("Don quijote");
                dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse("2000-05-20");
                libro.setFechaLanzamiento(dateFormat);

                autor.setNombre("Tamara");
                autor.setApellido("Herrera");
                autor.setEmail("THerrera@gmail.com");
                nacionalidad.setDescripcion("Estados Unidos");
                negNacionalidad.addNationality(nacionalidad);
                autor.setNacionalidad(nacionalidad);
                negAutorImpl.addWritter(autor);

                libro.setAutor(autor);
                libro.setCantidadPaginas(580);
                libro.setDescripcion("Una historia de un perro y su familia");
                dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse("1995-05-04");
                libro.setFechaLanzamiento(dateFormat);
				
                libro.setGeneros(generos);
				libro.setIdioma("Ingles");
				libro.setISBN(1234);
				libro.setTitulo("Marley y yo");
				negLibrosImpl.addBook(libro);
                
				libro.setAutor(autor);
				libro.setCantidadPaginas(30);
				libro.setDescripcion("La historia de la ballena Moby dick");
				dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-01");
				libro.setFechaLanzamiento(dateFormat);

				generos = new HashSet<>();
				generos.add(genero);
				libro.setGeneros(generos);
				libro.setIdioma("Ingles");
				libro.setISBN(999);
				libro.setTitulo("Moby dick");
				negLibrosImpl.addBook(libro);

				biblioteca.setEstado("En biblioteca");
				biblioteca.setFechaDeAlta(new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01"));
				biblioteca.setLibro(libro);
				negBibliotecaImpl.addBiblioteca(biblioteca);
				
				prestamo.setBiblioteca(biblioteca);
				prestamo.setCantDias(1);
				prestamo.setCliente(cliente);
				prestamo.setFechaDePrestamo(new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01"));
				prestamo.setEstado(false);
				negPrestamosImpl.addLoan(prestamo);
				
				biblioteca.setEstado("Prestado");
				biblioteca.setFechaDeAlta(new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01"));
				biblioteca.setLibro(libro);
				negBibliotecaImpl.addBiblioteca(biblioteca);
				
				prestamo.setBiblioteca(biblioteca);
				prestamo.setCantDias(1);
				prestamo.setCliente(cliente);
				prestamo.setFechaDePrestamo(new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01"));
				prestamo.setEstado(true);
				negPrestamosImpl.addLoan(prestamo);
				
				autor.setNombre("Matias");
                autor.setApellido("Seeber");
                autor.setEmail("mseeber@gmail.com");
                nacionalidad.setDescripcion("Paraguay");
                negNacionalidad.addNationality(nacionalidad);
                autor.setNacionalidad(nacionalidad);
                negAutorImpl.addWritter(autor);

                libro.setAutor(autor);
                libro.setCantidadPaginas(250);
                libro.setTitulo("La gallina turuleca");
                dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse("1998-05-20");
                libro.setFechaLanzamiento(dateFormat);

                generos = new HashSet<>();
                generos.add(genero);
                libro.setGeneros(generos);
                libro.setIdioma("Aleman");
                libro.setISBN(4590);
                libro.setDescripcion("La gallina turuleca a puesto un huevo a puesto dos a puesto tres");
                negLibrosImpl.addBook(libro);
				
			} catch (Exception e) {
				System.out.println("Excepcion al añadir la informacion en la base de datos: " + e.getMessage());
			}
			wasDataInserted = true;
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping("getUser.html")
	public ModelAndView eventoLogin(String email, String password) {
		System.out.println("Mapping getUser.html");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("email", email);
		modelAndView.addObject("password", password);
		String nextPage = "";
		if (negUsuarios.doesUserExists(email, password)) {
			ArrayList<Libro> listLibros = negLibrosImpl.getBooks();
			if (listLibros.size() > 0)
				modelAndView.addObject("libros", listLibros);
			ArrayList<Biblioteca> list = negBibliotecaImpl.getBibliotecas();
			if (list.size() > 0)
				modelAndView.addObject("bibliotecas", list);
			nextPage = "libros";
			user = negUsuarios.obtainUserByPasswordAndEmail(email, password);
			nombreUsuario = user.getUsername();
		} else {
			modelAndView.addObject("msg", "El email/nombre de usuario o la contraseña son incorrectos.");
			nextPage = "index";
			modelAndView.setViewName(nextPage);
			return modelAndView;
		}
		modelAndView.addObject("username", nombreUsuario);
		modelAndView.setViewName("libros");
		modelAndView.setViewName(nextPage);
		return modelAndView;
	}

	@RequestMapping("addBook.html")
	public ModelAndView eventoAddBook(int Libro, String fechaAlta) {
		System.out.println("Mapping addBook.html");
		ModelAndView modelAndView = new ModelAndView();
		biblioteca.setEstado("En biblioteca");
		Date dateFormat;
		try {
			dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse(fechaAlta);
			biblioteca.setFechaDeAlta(dateFormat);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		libro.setISBN(Libro);
		biblioteca.setLibro(libro);
		if (negBibliotecaImpl.addBiblioteca(biblioteca))
			modelAndView.addObject("msg", "El libro fue dado de alta en la biblioteca exitosamente.");
		else
			modelAndView.addObject("msg", "El libro no se pudo dar de alta en la biblioteca.");
		ArrayList<Libro> listLibros = negLibrosImpl.getBooks();
		if (listLibros.size() > 0)
			modelAndView.addObject("libros", listLibros);
		ArrayList<Biblioteca> list = negBibliotecaImpl.getBibliotecas();
		if (list.size() > 0)
			modelAndView.addObject("bibliotecas", list);
		modelAndView.setViewName("libros");
		modelAndView.addObject("username", nombreUsuario);
		return modelAndView;
	}

	@RequestMapping("clientes.html")
	public ModelAndView eventoCargarClientes() {
		ModelAndView modelAndView = new ModelAndView();
		if (nombreUsuario.isEmpty()) {
			modelAndView.setViewName("index");
			return modelAndView;
		}
		System.out.println("Mapping clientes.html");
		ArrayList<Clientes> list = negClientesImpl.GetClients();
		if (list.size() > 0)
			modelAndView.addObject("clientesList", list);
		ArrayList<Nacionalidad> listNacionalidades = negNacionalidad.getNationalities();
		if (listNacionalidades.size() > 0)
			modelAndView.addObject("nacionalidadesList", listNacionalidades);
		modelAndView.addObject("username", nombreUsuario);
		modelAndView.setViewName("clientes");
		return modelAndView;
	}

	@RequestMapping("modificarCliente.html")
	public ModelAndView eventoModificarCliente(int id, int dni, String name, String surname, int nationality,
			String sex, String date, String address, int phone, String district, String email) {
		System.out.println("modificarCliente.html");
		ModelAndView modelAndView = new ModelAndView();
		cliente.setID(id);
		cliente.setDni(dni);
		cliente.setNombre(name);
		cliente.setApellido(surname);
		nacionalidad.setID(nationality);
		cliente.setNacionalidad(nacionalidad);
		cliente.setEmail(email);
		cliente.setDireccion(address);
		Date dateFormat;
		try {
			dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			cliente.setFechaNacimiento(dateFormat);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cliente.setSexo(sex);
		cliente.setTelefono(phone);
		cliente.setLocalidad(district);

		boolean wasClientModified = negClientesImpl.ModifyClient(cliente);

		if (wasClientModified)
			modelAndView.addObject("msg", "El cliente fue modificado .");
		else
			modelAndView.addObject("msg", "El cliente no se pudo añadir.");

		ArrayList<Clientes> list = negClientesImpl.GetClients();
		if (list.size() > 0)
			modelAndView.addObject("clientesList", list);

		ArrayList<Nacionalidad> listNacionalidades = negNacionalidad.getNationalities();
		if (listNacionalidades.size() > 0)
			modelAndView.addObject("nacionalidadesList", listNacionalidades);
		modelAndView.addObject("username", nombreUsuario);
		modelAndView.setViewName("clientes");
		return modelAndView;
	}

	@RequestMapping("/eliminarCliente.html")
	public ModelAndView eliminarBiblioteca(@RequestParam(value = "id", required = false) int id) {
		ModelAndView modelAndView = new ModelAndView();
		cliente.setID(id);

		boolean wasClientModified = negClientesImpl.deleteClient(cliente);

		if (wasClientModified)
			modelAndView.addObject("msg", "El cliente fue eilminado exitosamente.");
		else
			modelAndView.addObject("msg", "Un cliente con prestamos activos no se puede eliminar.");

		ArrayList<Clientes> list = negClientesImpl.GetClients();
		if (list.size() > 0)
			modelAndView.addObject("clientesList", list);

		ArrayList<Nacionalidad> listNacionalidades = negNacionalidad.getNationalities();
		if (listNacionalidades.size() > 0)
			modelAndView.addObject("nacionalidadesList", listNacionalidades);
		modelAndView.addObject("username", nombreUsuario);
		modelAndView.setViewName("clientes");
		return modelAndView;
	}

	@RequestMapping("libros.html")
	public ModelAndView eventoCargarLibros() {
		ModelAndView modelAndView = new ModelAndView();
		if (nombreUsuario.isEmpty()) {
			modelAndView.setViewName("index");
			return modelAndView;
		}
		System.out.println("Mapping libros.html");
		ArrayList<Libro> listLibros = negLibrosImpl.getBooks();
		if (listLibros.size() > 0)
			modelAndView.addObject("libros", listLibros);
		ArrayList<Biblioteca> list = negBibliotecaImpl.getBibliotecas();
		if (list.size() > 0)
			modelAndView.addObject("bibliotecas", list);
		modelAndView.addObject("username", nombreUsuario);
		modelAndView.setViewName("libros");
		return modelAndView;
	}

	@RequestMapping("prestamos.html")
	public ModelAndView eventoCargarPrestamos() {
		ModelAndView modelAndView = new ModelAndView();
		if (nombreUsuario.isEmpty()) {
			modelAndView.setViewName("index");
			return modelAndView;
		}
		System.out.println("Mapping prestamos.html");
		ArrayList<Biblioteca> list = negBibliotecaImpl.getAllAvailableBibliotecas();
		if (list.size() > 0)
			modelAndView.addObject("bibliotecas", list);
		ArrayList<Clientes> clientesList = negClientesImpl.GetClients();
		if (clientesList.size() > 0)
			modelAndView.addObject("clientesList", clientesList);
		ArrayList<Prestamos> loans = negPrestamosImpl.getLoans();
		if (loans.size() > 0)
			modelAndView.addObject("loans", loans);
		modelAndView.setViewName("prestamos");
		modelAndView.addObject("username", nombreUsuario);
		return modelAndView;
	}
	
	@RequestMapping("cerrarPrestamo.html")
	public ModelAndView eventoCerrarPrestamos(int idPrestamo) {
		System.out.println("cerrarPrestamo.html");
		ModelAndView modelAndView = new ModelAndView();
		if(nombreUsuario.isEmpty()) {
			modelAndView.setViewName("index");
			return modelAndView;
		}
		prestamo = negPrestamosImpl.getLoanByID(idPrestamo);
		prestamo.setEstado(false);
		if(!prestamo.equals(null) && negPrestamosImpl.modifyLoan(prestamo))
		{
			modelAndView.addObject("msg", "El prestamo fue cerrado exitosamente");
			biblioteca = prestamo.getBiblioteca();
			biblioteca.setEstado("En biblioteca");
			negBibliotecaImpl.modifyBiblioteca(biblioteca);
		}
		else
			modelAndView.addObject("msg", "El prestamo no pudo cerrarse.");
		modelAndView.setViewName("prestamos");
		ArrayList<Biblioteca> list = negBibliotecaImpl.getAllAvailableBibliotecas();
		if (list.size() > 0)
			modelAndView.addObject("bibliotecas", list);
		ArrayList<Clientes> clientesList = negClientesImpl.GetClients();
		if (clientesList.size() > 0)
			modelAndView.addObject("clientesList", clientesList);
		ArrayList<Prestamos> loans = negPrestamosImpl.getLoans();
		if (loans.size() > 0)
			modelAndView.addObject("loans", loans);
		modelAndView.addObject("username", nombreUsuario);
		return modelAndView;
	}

	@RequestMapping("addLoan.html")
	public ModelAndView eventoAñadirPrestamos(int Biblioteca, String date, int cantdias, int client) {
		System.out.println("addLoan.html");
		ModelAndView modelAndView = new ModelAndView();
	
		biblioteca.setID(Biblioteca);
		biblioteca.setLibro(negBibliotecaImpl.getBibliotecaById(Biblioteca).getLibro());
		prestamo.setBiblioteca(biblioteca);
		try {
			prestamo.setFechaDePrestamo(new SimpleDateFormat("yyyy-MM-dd").parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		prestamo.setCantDias(cantdias);
		cliente.setID(client);
		prestamo.setCliente(negClientesImpl.GetClientByID(client));
		prestamo.setEstado(true);
		if(negPrestamosImpl.addLoan(prestamo))
		{
			modelAndView.addObject("msg", "El prestamo se pudo añadir exitosamente.");
			biblioteca = negBibliotecaImpl.getBibliotecaById(Biblioteca);
			biblioteca.setEstado("Prestado");
			negBibliotecaImpl.modifyBiblioteca(biblioteca);
		}
		else
		{
			modelAndView.addObject("msg", "El prestamo no se pudo añadir.");
		}
		
		ArrayList<Prestamos> loans = negPrestamosImpl.getLoans();
		if (loans.size() > 0)
			modelAndView.addObject("loans", loans);
		
		ArrayList<Clientes> list = negClientesImpl.GetClients();
		if (list.size() > 0)
			modelAndView.addObject("clientesList", list);

		ArrayList<Biblioteca> listBibliotecas = negBibliotecaImpl.getAllAvailableBibliotecas();
		if (listBibliotecas.size() > 0)
			modelAndView.addObject("bibliotecas", listBibliotecas);

		modelAndView.addObject("username", nombreUsuario);
		modelAndView.setViewName("prestamos");
		return modelAndView;
	}

	@RequestMapping("addClient.html")
	public ModelAndView eventoAñadirCliente(int dni, String name, String surname, int nationality, String sex,
			String date, String address, int phone, String district, String email) {
		System.out.println("addClient.html");
		ModelAndView modelAndView = new ModelAndView();

		if (negClientesImpl.doesClientExist(dni, email)) {
			modelAndView.addObject("msg", "El cliente ya existe");
		} else {
			cliente.setDni(dni);
			cliente.setNombre(name);
			cliente.setApellido(surname);
			nacionalidad.setID(nationality);
			cliente.setNacionalidad(nacionalidad);
			cliente.setEmail(email);
			cliente.setDireccion(address);
			Date dateFormat;
			try {
				dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse(date);
				cliente.setFechaNacimiento(dateFormat);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			cliente.setSexo(sex);
			cliente.setTelefono(phone);
			cliente.setLocalidad(district);

			boolean wasClientModified = negClientesImpl.AddClient(cliente);

			if (wasClientModified)
				modelAndView.addObject("msg", "El cliente fue añadido correctamente.");
			else
				modelAndView.addObject("msg", "El cliente no se pudo añadir.");
		}

		ArrayList<Clientes> list = negClientesImpl.GetClients();
		if (list.size() > 0)
			modelAndView.addObject("clientesList", list);

		ArrayList<Nacionalidad> listNacionalidades = negNacionalidad.getNationalities();
		if (listNacionalidades.size() > 0)
			modelAndView.addObject("nacionalidadesList", listNacionalidades);
		modelAndView.addObject("username", nombreUsuario);
		modelAndView.setViewName("clientes");
		return modelAndView;
	}

	@RequestMapping("eliminarBiblioteca.html")
	public ModelAndView eventoEliminarBiblioteca(int id, String estado) {
		System.out.println("Mapping eliminarBiblioteca.html");
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("estado " + estado);
		if (!estado.equals("En biblioteca")) {
			modelAndView.addObject("msg", "No se puede dar de baja una biblioteca que tenga un prestamo activo.");
		} else {
			biblioteca = negBibliotecaImpl.getBibliotecaById(id);
			biblioteca.setEstado("Dado de baja");
			if (negBibliotecaImpl.modifyBiblioteca(biblioteca))
				modelAndView.addObject("msg", "La biblioteca fue dada de baja exitosamente.");
			else
				modelAndView.addObject("msg", "No se puedo dar de baja la biblioteca.");
		}
		ArrayList<Libro> listLibros = negLibrosImpl.getBooks();
		if (listLibros.size() > 0)
			modelAndView.addObject("libros", listLibros);
		ArrayList<Biblioteca> list = negBibliotecaImpl.getBibliotecas();
		if (list.size() > 0)
			modelAndView.addObject("bibliotecas", list);
		nombreUsuario = user.getUsername();
		modelAndView.addObject("username", nombreUsuario);
		modelAndView.setViewName("libros");
		return modelAndView;
	}
}
