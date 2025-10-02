package uk.codery.demo.openreferrals.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uk.codery.demo.openreferrals.model.Location ;
import uk.codery.demo.openreferrals.model.Organization;
import uk.codery.demo.openreferrals.model.Service;
import uk.codery.demo.openreferrals.repository.LocationRepository;
import uk.codery.demo.openreferrals.repository.OrganizationRepository;
import uk.codery.demo.openreferrals.repository.ServiceRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final OrganizationRepository organizationRepository;
    private final LocationRepository locationRepository;
    private final ServiceRepository serviceRepository;

    @Override
    public void run(String... args) {
        // Clear existing data
        log.info("Clearing existing data...");
        serviceRepository.deleteAll();
        locationRepository.deleteAll();
        organizationRepository.deleteAll();

        log.info("Seeding database with Restart provision data...");

        // Create Organizations
        List<Organization> organizations = createOrganizations();
        
        // Create Locations
        List<Location> locations = createLocations();
        
        // Create Services
        createServices(organizations, locations);

        log.info("Database seeding completed successfully!");
    }

    private List<Organization> createOrganizations() {
        List<Organization> orgs = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();

        Organization restart = new Organization();
        restart.setName("Restart");
        restart.setDescription("Restart is a charity that helps unemployed people back to work through digital training and employment support");
        restart.setEmail("info@restart.org.uk");
        restart.setUrl("https://restart.org.uk");
        restart.setCreatedAt(now);
        restart.setUpdatedAt(now);
        orgs.add(organizationRepository.save(restart));

        Organization restartNetwork = new Organization();
        restartNetwork.setName("Restart Network");
        restartNetwork.setDescription("Community network providing digital skills training and support");
        restartNetwork.setEmail("network@restart.org.uk");
        restartNetwork.setUrl("https://restartnetwork.org.uk");
        restartNetwork.setCreatedAt(now);
        restartNetwork.setUpdatedAt(now);
        orgs.add(organizationRepository.save(restartNetwork));

        Organization digitalInclusionHub = new Organization();
        digitalInclusionHub.setName("Digital Inclusion Hub");
        digitalInclusionHub.setDescription("Supporting digital inclusion and skills development across communities");
        digitalInclusionHub.setEmail("contact@digitalhub.org.uk");
        digitalInclusionHub.setUrl("https://digitalhub.org.uk");
        digitalInclusionHub.setCreatedAt(now);
        digitalInclusionHub.setUpdatedAt(now);
        orgs.add(organizationRepository.save(digitalInclusionHub));

        Organization communityTechSupport = new Organization();
        communityTechSupport.setName("Community Tech Support");
        communityTechSupport.setDescription("Free technology support and training for local communities");
        communityTechSupport.setEmail("help@communitytechsupport.org.uk");
        communityTechSupport.setUrl("https://communitytechsupport.org.uk");
        communityTechSupport.setCreatedAt(now);
        communityTechSupport.setUpdatedAt(now);
        orgs.add(organizationRepository.save(communityTechSupport));

        log.info("Created {} organizations", orgs.size());
        return orgs;
    }

    private List<Location> createLocations() {
        List<Location> locs = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();

        // London locations
        Location londonCentral = new Location();
        londonCentral.setName("Restart London Central");
        londonCentral.setDescription("Main training center in central London");
        londonCentral.setAddress1("123 Tech Street");
        londonCentral.setCity("London");
        londonCentral.setPostalCode("EC1A 1BB");
        londonCentral.setCountry("United Kingdom");
        londonCentral.setLatitude(51.5074);
        londonCentral.setLongitude(-0.1278);
        londonCentral.setCreatedAt(now);
        londonCentral.setUpdatedAt(now);
        locs.add(locationRepository.save(londonCentral));

        Location londonEast = new Location();
        londonEast.setName("East London Community Hub");
        londonEast.setDescription("Community center offering digital skills workshops");
        londonEast.setAddress1("45 Hackney Road");
        londonEast.setCity("London");
        londonEast.setPostalCode("E2 7NX");
        londonEast.setCountry("United Kingdom");
        londonEast.setLatitude(51.5290);
        londonEast.setLongitude(-0.0551);
        londonEast.setCreatedAt(now);
        londonEast.setUpdatedAt(now);
        locs.add(locationRepository.save(londonEast));

        // Manchester location
        Location manchester = new Location();
        manchester.setName("Manchester Digital Center");
        manchester.setDescription("Digital skills and employment support center");
        manchester.setAddress1("78 Market Street");
        manchester.setCity("Manchester");
        manchester.setPostalCode("M1 1PW");
        manchester.setCountry("United Kingdom");
        manchester.setLatitude(53.4808);
        manchester.setLongitude(-2.2426);
        manchester.setCreatedAt(now);
        manchester.setUpdatedAt(now);
        locs.add(locationRepository.save(manchester));

        // Birmingham location
        Location birmingham = new Location();
        birmingham.setName("Birmingham Tech Hub");
        birmingham.setDescription("Technology training and support facility");
        birmingham.setAddress1("12 Bull Street");
        birmingham.setCity("Birmingham");
        birmingham.setPostalCode("B4 6AF");
        birmingham.setCountry("United Kingdom");
        birmingham.setLatitude(52.4862);
        birmingham.setLongitude(-1.8904);
        birmingham.setCreatedAt(now);
        birmingham.setUpdatedAt(now);
        locs.add(locationRepository.save(birmingham));

        // Leeds location
        Location leeds = new Location();
        leeds.setName("Leeds Learning Centre");
        leeds.setDescription("Adult learning and digital skills center");
        leeds.setAddress1("56 Briggate");
        leeds.setCity("Leeds");
        leeds.setPostalCode("LS1 6HD");
        leeds.setCountry("United Kingdom");
        leeds.setLatitude(53.7997);
        leeds.setLongitude(-1.5492);
        leeds.setCreatedAt(now);
        leeds.setUpdatedAt(now);
        locs.add(locationRepository.save(leeds));

        // Bristol location
        Location bristol = new Location();
        bristol.setName("Bristol Community Tech");
        bristol.setDescription("Community technology and training center");
        bristol.setAddress1("34 Park Street");
        bristol.setCity("Bristol");
        bristol.setPostalCode("BS1 5JG");
        bristol.setCountry("United Kingdom");
        bristol.setLatitude(51.4545);
        bristol.setLongitude(-2.5879);
        bristol.setCreatedAt(now);
        bristol.setUpdatedAt(now);
        locs.add(locationRepository.save(bristol));

        log.info("Created {} locations", locs.size());
        return locs;
    }

    private void createServices(List<Organization> organizations, List<Location> locations) {
        LocalDateTime now = LocalDateTime.now();
        List<Service> services = new ArrayList<>();

        // Digital Skills Training Services
        Service basicDigitalSkills = new Service();
        basicDigitalSkills.setName("Basic Digital Skills Training");
        basicDigitalSkills.setDescription("Learn essential computer skills including email, internet browsing, and online safety. Perfect for beginners.");
        basicDigitalSkills.setEmail("training@restart.org.uk");
        basicDigitalSkills.setUrl("https://restart.org.uk/basic-digital-skills");
        basicDigitalSkills.setStatus("active");
        basicDigitalSkills.setOrganization(organizations.get(0));
        basicDigitalSkills.setLocation(locations.get(0));
        basicDigitalSkills.setCreatedAt(now);
        basicDigitalSkills.setUpdatedAt(now);
        services.add(serviceRepository.save(basicDigitalSkills));

        Service advancedDigitalSkills = new Service();
        advancedDigitalSkills.setName("Advanced Digital Skills Workshop");
        advancedDigitalSkills.setDescription("Advanced training covering social media, online business tools, digital marketing, and cloud services.");
        advancedDigitalSkills.setEmail("advanced@restart.org.uk");
        advancedDigitalSkills.setUrl("https://restart.org.uk/advanced-skills");
        advancedDigitalSkills.setStatus("active");
        advancedDigitalSkills.setOrganization(organizations.get(0));
        advancedDigitalSkills.setLocation(locations.get(1));
        advancedDigitalSkills.setCreatedAt(now);
        advancedDigitalSkills.setUpdatedAt(now);
        services.add(serviceRepository.save(advancedDigitalSkills));

        // Employment Support Services
        Service jobSearchSupport = new Service();
        jobSearchSupport.setName("Job Search Support");
        jobSearchSupport.setDescription("One-to-one support with CV writing, job applications, and interview preparation. Help with online job portals.");
        jobSearchSupport.setEmail("jobs@restart.org.uk");
        jobSearchSupport.setUrl("https://restart.org.uk/job-support");
        jobSearchSupport.setStatus("active");
        jobSearchSupport.setOrganization(organizations.get(0));
        jobSearchSupport.setLocation(locations.get(0));
        jobSearchSupport.setCreatedAt(now);
        jobSearchSupport.setUpdatedAt(now);
        services.add(serviceRepository.save(jobSearchSupport));

        Service careerGuidance = new Service();
        careerGuidance.setName("Career Guidance and Mentoring");
        careerGuidance.setDescription("Professional career advice and mentoring to help you identify opportunities and develop your career path.");
        careerGuidance.setEmail("careers@restart.org.uk");
        careerGuidance.setUrl("https://restart.org.uk/career-guidance");
        careerGuidance.setStatus("active");
        careerGuidance.setOrganization(organizations.get(0));
        careerGuidance.setLocation(locations.get(2));
        careerGuidance.setCreatedAt(now);
        careerGuidance.setUpdatedAt(now);
        services.add(serviceRepository.save(careerGuidance));

        // Computer Refurbishment and Access
        Service laptopDonation = new Service();
        laptopDonation.setName("Free Laptop Scheme");
        laptopDonation.setDescription("Providing refurbished laptops to those in need. Recipients receive basic training and ongoing support.");
        laptopDonation.setEmail("laptops@restartnetwork.org.uk");
        laptopDonation.setUrl("https://restartnetwork.org.uk/laptop-scheme");
        laptopDonation.setStatus("active");
        laptopDonation.setOrganization(organizations.get(1));
        laptopDonation.setLocation(locations.get(0));
        laptopDonation.setCreatedAt(now);
        laptopDonation.setUpdatedAt(now);
        services.add(serviceRepository.save(laptopDonation));

        Service computerRecycling = new Service();
        computerRecycling.setName("Computer Recycling and Repair");
        computerRecycling.setDescription("Volunteer-led computer repair and recycling service. Learn to fix computers while supporting the community.");
        computerRecycling.setEmail("repair@restartnetwork.org.uk");
        computerRecycling.setUrl("https://restartnetwork.org.uk/repair");
        computerRecycling.setStatus("active");
        computerRecycling.setOrganization(organizations.get(1));
        computerRecycling.setLocation(locations.get(3));
        computerRecycling.setCreatedAt(now);
        computerRecycling.setUpdatedAt(now);
        services.add(serviceRepository.save(computerRecycling));

        // Digital Inclusion Services
        Service seniorsTech = new Service();
        seniorsTech.setName("Tech for Seniors");
        seniorsTech.setDescription("Technology training specifically designed for older adults. Learn at your own pace in a supportive environment.");
        seniorsTech.setEmail("seniors@digitalhub.org.uk");
        seniorsTech.setUrl("https://digitalhub.org.uk/seniors");
        seniorsTech.setStatus("active");
        seniorsTech.setOrganization(organizations.get(2));
        seniorsTech.setLocation(locations.get(4));
        seniorsTech.setCreatedAt(now);
        seniorsTech.setUpdatedAt(now);
        services.add(serviceRepository.save(seniorsTech));

        Service familyDigital = new Service();
        familyDigital.setName("Family Digital Skills");
        familyDigital.setDescription("Help your whole family get online. Workshops covering online safety, educational resources, and family communication.");
        familyDigital.setEmail("family@digitalhub.org.uk");
        familyDigital.setUrl("https://digitalhub.org.uk/family");
        familyDigital.setStatus("active");
        familyDigital.setOrganization(organizations.get(2));
        familyDigital.setLocation(locations.get(5));
        familyDigital.setCreatedAt(now);
        familyDigital.setUpdatedAt(now);
        services.add(serviceRepository.save(familyDigital));

        Service onlineSafety = new Service();
        onlineSafety.setName("Online Safety Workshop");
        onlineSafety.setDescription("Learn how to stay safe online, protect your personal information, and identify scams and fraud.");
        onlineSafety.setEmail("safety@digitalhub.org.uk");
        onlineSafety.setUrl("https://digitalhub.org.uk/safety");
        onlineSafety.setStatus("active");
        onlineSafety.setOrganization(organizations.get(2));
        onlineSafety.setLocation(locations.get(1));
        onlineSafety.setCreatedAt(now);
        onlineSafety.setUpdatedAt(now);
        services.add(serviceRepository.save(onlineSafety));

        // Tech Support Services
        Service techHelpDesk = new Service();
        techHelpDesk.setName("Tech Help Desk");
        techHelpDesk.setDescription("Drop-in support for any technology questions. Volunteers available to help with devices, software, and online services.");
        techHelpDesk.setEmail("help@communitytechsupport.org.uk");
        techHelpDesk.setUrl("https://communitytechsupport.org.uk/helpdesk");
        techHelpDesk.setStatus("active");
        techHelpDesk.setOrganization(organizations.get(3));
        techHelpDesk.setLocation(locations.get(2));
        techHelpDesk.setCreatedAt(now);
        techHelpDesk.setUpdatedAt(now);
        services.add(serviceRepository.save(techHelpDesk));

        Service onlineEssentials = new Service();
        onlineEssentials.setName("Online Essentials - Benefits & Healthcare");
        onlineEssentials.setDescription("Support with accessing online benefits, healthcare services, and government portals. Assistance with Universal Credit and NHS online services.");
        onlineEssentials.setEmail("essentials@communitytechsupport.org.uk");
        onlineEssentials.setUrl("https://communitytechsupport.org.uk/essentials");
        onlineEssentials.setStatus("active");
        onlineEssentials.setOrganization(organizations.get(3));
        onlineEssentials.setLocation(locations.get(3));
        onlineEssentials.setCreatedAt(now);
        onlineEssentials.setUpdatedAt(now);
        services.add(serviceRepository.save(onlineEssentials));

        Service codingBootcamp = new Service();
        codingBootcamp.setName("Introduction to Coding");
        codingBootcamp.setDescription("Free beginner-friendly coding bootcamp. Learn HTML, CSS, and basic JavaScript to start your tech career.");
        codingBootcamp.setEmail("coding@restart.org.uk");
        codingBootcamp.setUrl("https://restart.org.uk/coding");
        codingBootcamp.setStatus("active");
        codingBootcamp.setOrganization(organizations.get(0));
        codingBootcamp.setLocation(locations.get(4));
        codingBootcamp.setCreatedAt(now);
        codingBootcamp.setUpdatedAt(now);
        services.add(serviceRepository.save(codingBootcamp));

        Service dataSkills = new Service();
        dataSkills.setName("Data Skills for Employment");
        dataSkills.setDescription("Learn Excel, data entry, and basic data analysis skills that employers are looking for.");
        dataSkills.setEmail("data@restart.org.uk");
        dataSkills.setUrl("https://restart.org.uk/data-skills");
        dataSkills.setStatus("active");
        dataSkills.setOrganization(organizations.get(0));
        dataSkills.setLocation(locations.get(5));
        dataSkills.setCreatedAt(now);
        dataSkills.setUpdatedAt(now);
        services.add(serviceRepository.save(dataSkills));

        log.info("Created {} services", services.size());
    }
}