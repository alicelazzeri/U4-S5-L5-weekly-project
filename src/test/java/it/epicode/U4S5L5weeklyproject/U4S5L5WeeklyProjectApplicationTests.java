package it.epicode.U4S5L5weeklyproject;

import it.epicode.U4S5L5weeklyproject.entities.Booking;
import it.epicode.U4S5L5weeklyproject.entities.Building;
import it.epicode.U4S5L5weeklyproject.entities.User;
import it.epicode.U4S5L5weeklyproject.entities.WorkStation;
import it.epicode.U4S5L5weeklyproject.entities.enums.WorkStationType;
import it.epicode.U4S5L5weeklyproject.exceptions.BookingNotFoundException;
import it.epicode.U4S5L5weeklyproject.exceptions.WorkStationNotFoundException;
import it.epicode.U4S5L5weeklyproject.services.BookingService;
import it.epicode.U4S5L5weeklyproject.services.BuildingService;
import it.epicode.U4S5L5weeklyproject.services.UserService;
import it.epicode.U4S5L5weeklyproject.services.WorkStationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class U4S5L5WeeklyProjectApplicationTests {

	@Autowired
	private BuildingService buildingService;

	@Autowired
	private WorkStationService workStationService;

	@Autowired
	private UserService userService;

	@Autowired
	private BookingService bookingService;

	@Test
	public void testFindAllBuildings() {
		assertNotNull(buildingService.findAllBuildings());
	}

	@Test
	public void testFindUserByUsername() {

		String expectedUsername = "alice_lazzeri";
		User user = userService.findUserByUsername(expectedUsername);
		assertEquals(expectedUsername, user.getUsername());
	}

	@Test
	public void testDeleteWorkStation() {

		Building building = Building.builder()
				.withBuildingName("Prova building name")
				.withCity("Prova city")
				.withBuildingAddress("Prova address")
				.build();

		WorkStation workStation = WorkStation.builder()
				.withDescription("Prova Work Station")
				.withWorkStationType(WorkStationType.OPEN_SPACE)
				.withBuilding(building)
				.withMaxOccupants(10)
				.build();

		buildingService.saveBuilding(building);
		long workStationId = workStation.getId();
		workStationService.saveWorkStation(workStation);
		workStationService.deleteWorkStation(workStationId);

	    assertThrows(WorkStationNotFoundException.class, () -> { workStationService.findWorkStationById(workStationId); });
	}

	@Test
	public void deleteBooking() {

		Building building = Building.builder()
				.withBuildingName("Prova building name")
				.withCity("Prova city")
				.withBuildingAddress("Prova address")
				.build();

		buildingService.saveBuilding(building);

		WorkStation workStation = WorkStation.builder()
				.withDescription("Prova Work Station")
				.withWorkStationType(WorkStationType.OPEN_SPACE)
				.withBuilding(building)
				.withMaxOccupants(10)
				.build();

		workStationService.saveWorkStation(workStation);

		User user = User.builder()
				.withUserEmail("example@gmail.com")
				.withFullName("Prova name")
				.withUsername("prova_name")
				.build();

		userService.saveUser(user);

		Booking booking = Booking.builder()
				.withBookingDate(LocalDate.now())
				.withWorkStation(workStation)
				.withUser(user)
				.build();

		bookingService.saveBooking(booking);
		long bookingId = booking.getId();
		bookingService.deleteBooking(bookingId);

		assertThrows(BookingNotFoundException.class, () -> bookingService.findBookingById(bookingId));

		// workStationService.findWorkStationsByWorkStationTypeAndCity(WorkStationType workStationType, String city);
	}

	@Test
	public void testFindWorkStationsByWorkStationTypeAndCity() {

		Building building = Building.builder()
				.withBuildingName("Prova building name")
				.withCity("Prova city")
				.withBuildingAddress("Prova address")
				.build();

		buildingService.saveBuilding(building);

		WorkStation workStation = WorkStation.builder()
				.withDescription("Prova Work Station")
				.withWorkStationType(WorkStationType.OPEN_SPACE)
				.withBuilding(building)
				.withMaxOccupants(10)
				.build();

		workStationService.saveWorkStation(workStation);

		List<WorkStation> foundWorkStations =  workStationService.findWorkStationsByWorkStationTypeAndCity
				(workStation.getWorkStationType(), building.getCity());

		assertFalse(foundWorkStations.isEmpty());
	}
}
