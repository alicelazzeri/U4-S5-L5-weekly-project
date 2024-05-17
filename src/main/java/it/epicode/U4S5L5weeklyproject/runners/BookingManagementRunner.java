package it.epicode.U4S5L5weeklyproject.runners;

import it.epicode.U4S5L5weeklyproject.entities.Booking;
import it.epicode.U4S5L5weeklyproject.entities.Building;
import it.epicode.U4S5L5weeklyproject.entities.User;
import it.epicode.U4S5L5weeklyproject.entities.WorkStation;
import it.epicode.U4S5L5weeklyproject.entities.enums.WorkStationType;
import it.epicode.U4S5L5weeklyproject.services.BookingService;
import it.epicode.U4S5L5weeklyproject.services.BuildingService;
import it.epicode.U4S5L5weeklyproject.services.UserService;
import it.epicode.U4S5L5weeklyproject.services.WorkStationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j

public class BookingManagementRunner implements CommandLineRunner {

    @Autowired
    WorkStationService workStationService;

    @Autowired
    UserService userService;

    @Autowired
    BuildingService buildingService;

    @Autowired
    BookingService bookingService;

    @Override
    public void run(String... args) throws Exception {

        log.info("Creation of new instances of Building:");

        Building building1 = Building.builder()
                .withBuildingName("Tech Hub")
                .withBuildingAddress("123 Tech Street")
                .withCity("Rome, Italy")
                .build();

        Building building2 = Building.builder()
                .withBuildingName("Business Center")
                .withBuildingAddress("456 Business Avenue")
                .withCity("Florence, Italy")
                .build();

        Building building3 = Building.builder()
                .withBuildingName("Innovation Center")
                .withBuildingAddress("789 Innovation Boulevard")
                .withCity("Milan, Italy")
                .build();

        log.info("Saving of new instances of Building:");

        buildingService.saveBuilding(building1);
        buildingService.saveBuilding(building2);
        buildingService.saveBuilding(building3);

        log.info("Creation of new instances of WorkStation:");

        WorkStation workStation1 = WorkStation.builder()
                .withDescription("Private Office")
                .withWorkStationType(WorkStationType.PRIVATE)
                .withBuilding(building1)
                .withMaxOccupants(2)
                .build();

        WorkStation workStation2 = WorkStation.builder()
                .withDescription("Open Space Hub")
                .withWorkStationType(WorkStationType.OPEN_SPACE)
                .withBuilding(building2)
                .withMaxOccupants(20)
                .build();

        WorkStation workStation3 = WorkStation.builder()
                .withDescription("Convention and Meeting Centre")
                .withWorkStationType(WorkStationType.MEETING_ROOM)
                .withBuilding(building3)
                .withMaxOccupants(50)
                .build();

        log.info("Saving of new instances of WorkStation:");

        workStationService.saveWorkStation(workStation1);
        workStationService.saveWorkStation(workStation2);
        workStationService.saveWorkStation(workStation3);

        log.info("Creation of new instances of User:");

        User user1 = User.builder()
                .withUsername("alice_lazzeri")
                .withFullName("Alice Lazzeri")
                .withUserEmail("alice@outlook.com")
                .build();

        User user2 = User.builder()
                .withUsername("mariorossi90")
                .withFullName("Mario Rossi")
                .withUserEmail("marioss@gmail.com")
                .build();

        User user3 = User.builder()
                .withUsername("anna-neri")
                .withFullName("Anna Neri")
                .withUserEmail("nerianna@hotmail.com")
                .build();

        log.info("Saving of new instances of User:");

        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);

        log.info("Creation of new instances of Booking:");

        Booking booking1 = Booking.builder()
                .withBookingDate(LocalDate.now())
                .withWorkStation(workStation1)
                .withUser(user1)
                .build();

        Booking booking2 = Booking.builder()
                .withBookingDate(LocalDate.of(2024, 5, 16))
                .withWorkStation(workStation2)
                .withUser(user2)
                .build();

        Booking booking3 = Booking.builder()
                .withBookingDate(LocalDate.of(2024, 5, 15))
                .withWorkStation(workStation3)
                .withUser(user3)
                .build();

        log.info("Saving of new instances of Booking:");

        bookingService.saveBooking(booking1);
        bookingService.saveBooking(booking2);
        bookingService.saveBooking(booking3);


    }
}
