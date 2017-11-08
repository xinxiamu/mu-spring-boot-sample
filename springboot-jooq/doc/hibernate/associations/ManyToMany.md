###### 单向 @ManyToMany

- 实体：

	@Entity(name = "Person")
	public static class Person {
	
	    @Id
	    @GeneratedValue
	    private Long id;
	    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	    private List<Address> addresses = new ArrayList<>();
	
	    public Person() {
	    }
	
	    public List<Address> getAddresses() {
	        return addresses;
	    }
	}
	
	@Entity(name = "Address")
	public static class Address {
	
	    @Id
	    @GeneratedValue
	    private Long id;
	
	    private String street;
	
	    @Column(name = "`number`")
	    private String number;
	
	    public Address() {
	    }
	
	    public Address(String street, String number) {
	        this.street = street;
	        this.number = number;
	    }
	
	    public Long getId() {
	        return id;
	    }
	
	    public String getStreet() {
	        return street;
	    }
	
	    public String getNumber() {
	        return number;
	    }
	}
	
- 生成sql：

	CREATE TABLE Address (
	    id BIGINT NOT NULL ,
	    number VARCHAR(255) ,
	    street VARCHAR(255) ,
	    PRIMARY KEY ( id )
	)
	
	CREATE TABLE Person (
	    id BIGINT NOT NULL ,
	    PRIMARY KEY ( id )
	)
	
	CREATE TABLE Person_Address (
	    Person_id BIGINT NOT NULL ,
	    addresses_id BIGINT NOT NULL
	)
	
	ALTER TABLE Person_Address
	ADD CONSTRAINT FKm7j0bnabh2yr0pe99il1d066u
	FOREIGN KEY (addresses_id) REFERENCES Address
	
	ALTER TABLE Person_Address
	ADD CONSTRAINT FKba7rc9qe2vh44u93u0p2auwti
	FOREIGN KEY (Person_id) REFERENCES Person
	
- 操作：

	Person person1 = new Person();
	Person person2 = new Person();
	
	Address address1 = new Address( "12th Avenue", "12A" );
	Address address2 = new Address( "18th Avenue", "18B" );
	
	person1.getAddresses().add( address1 );
	person1.getAddresses().add( address2 );
	
	person2.getAddresses().add( address1 );
	
	entityManager.persist( person1 );
	entityManager.persist( person2 );
	
	entityManager.flush();
	
	person1.getAddresses().remove( address1 );
	
	-------------------------------------------
	INSERT INTO Person ( id )
	VALUES ( 1 )
	
	INSERT INTO Address ( number, street, id )
	VALUES ( '12A', '12th Avenue', 2 )
	
	INSERT INTO Address ( number, street, id )
	VALUES ( '18B', '18th Avenue', 3 )
	
	INSERT INTO Person ( id )
	VALUES ( 4 )
	
	INSERT INTO Person_Address ( Person_id, addresses_id )
	VALUES ( 1, 2 )
	INSERT INTO Person_Address ( Person_id, addresses_id )
	VALUES ( 1, 3 )
	INSERT INTO Person_Address ( Person_id, addresses_id )
	VALUES ( 4, 2 )
	
	DELETE FROM Person_Address
	WHERE  Person_id = 1
	
	INSERT INTO Person_Address ( Person_id, addresses_id )
	VALUES ( 1, 3 )
	
###### 双向 @ManyToMany

- 实体：

	@Entity(name = "Person")
	public static class Person {
	
	    @Id
	    @GeneratedValue
	    private Long id;
	
	    @NaturalId
	    private String registrationNumber;
	    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	    private List<Address> addresses = new ArrayList<>();
	
	    public Person() {
	    }
	
	    public Person(String registrationNumber) {
	        this.registrationNumber = registrationNumber;
	    }
	
	    public List<Address> getAddresses() {
	        return addresses;
	    }
	
	    public void addAddress(Address address) {
	        addresses.add( address );
	        address.getOwners().add( this );
	    }
	
	    public void removeAddress(Address address) {
	        addresses.remove( address );
	        address.getOwners().remove( this );
	    }
	
	    @Override
	    public boolean equals(Object o) {
	        if ( this == o ) {
	            return true;
	        }
	        if ( o == null || getClass() != o.getClass() ) {
	            return false;
	        }
	        Person person = (Person) o;
	        return Objects.equals( registrationNumber, person.registrationNumber );
	    }
	
	    @Override
	    public int hashCode() {
	        return Objects.hash( registrationNumber );
	    }
	}
	
	@Entity(name = "Address")
	public static class Address {
	
	    @Id
	    @GeneratedValue
	    private Long id;
	
	    private String street;
	
	    @Column(name = "`number`")
	    private String number;
	
	    private String postalCode;
	
	    @ManyToMany(mappedBy = "addresses")
	    private List<Person> owners = new ArrayList<>();
	
	    public Address() {
	    }
	
	    public Address(String street, String number, String postalCode) {
	        this.street = street;
	        this.number = number;
	        this.postalCode = postalCode;
	    }
	
	    public Long getId() {
	        return id;
	    }
	
	    public String getStreet() {
	        return street;
	    }
	
	    public String getNumber() {
	        return number;
	    }
	
	    public String getPostalCode() {
	        return postalCode;
	    }
	
	    public List<Person> getOwners() {
	        return owners;
	    }
	
	    @Override
	    public boolean equals(Object o) {
	        if ( this == o ) {
	            return true;
	        }
	        if ( o == null || getClass() != o.getClass() ) {
	            return false;
	        }
	        Address address = (Address) o;
	        return Objects.equals( street, address.street ) &&
	                Objects.equals( number, address.number ) &&
	                Objects.equals( postalCode, address.postalCode );
	    }
	
	    @Override
	    public int hashCode() {
	        return Objects.hash( street, number, postalCode );
	    }
	}
	
- 生成sql：

	CREATE TABLE Address (
	    id BIGINT NOT NULL ,
	    number VARCHAR(255) ,
	    postalCode VARCHAR(255) ,
	    street VARCHAR(255) ,
	    PRIMARY KEY ( id )
	)
	
	CREATE TABLE Person (
	    id BIGINT NOT NULL ,
	    registrationNumber VARCHAR(255) ,
	    PRIMARY KEY ( id )
	)
	
	CREATE TABLE Person_Address (
	    owners_id BIGINT NOT NULL ,
	    addresses_id BIGINT NOT NULL
	)
	
	ALTER TABLE Person
	ADD CONSTRAINT UK_23enodonj49jm8uwec4i7y37f
	UNIQUE (registrationNumber)
	
	ALTER TABLE Person_Address
	ADD CONSTRAINT FKm7j0bnabh2yr0pe99il1d066u
	FOREIGN KEY (addresses_id) REFERENCES Address
	
	ALTER TABLE Person_Address
	ADD CONSTRAINT FKbn86l24gmxdv2vmekayqcsgup
	FOREIGN KEY (owners_id) REFERENCES Person
	
- 操作：

	Person person1 = new Person( "ABC-123" );
	Person person2 = new Person( "DEF-456" );
	
	Address address1 = new Address( "12th Avenue", "12A", "4005A" );
	Address address2 = new Address( "18th Avenue", "18B", "4007B" );
	
	person1.addAddress( address1 );
	person1.addAddress( address2 );
	
	person2.addAddress( address1 );
	
	entityManager.persist( person1 );
	entityManager.persist( person2 );
	
	entityManager.flush();
	
	person1.removeAddress( address1 );
	
	------------------------------------------
	INSERT INTO Person ( registrationNumber, id )
	VALUES ( 'ABC-123', 1 )
	
	INSERT INTO Address ( number, postalCode, street, id )
	VALUES ( '12A', '4005A', '12th Avenue', 2 )
	
	INSERT INTO Address ( number, postalCode, street, id )
	VALUES ( '18B', '4007B', '18th Avenue', 3 )
	
	INSERT INTO Person ( registrationNumber, id )
	VALUES ( 'DEF-456', 4 )
	
	INSERT INTO Person_Address ( owners_id, addresses_id )
	VALUES ( 1, 2 )
	
	INSERT INTO Person_Address ( owners_id, addresses_id )
	VALUES ( 1, 3 )
	
	INSERT INTO Person_Address ( owners_id, addresses_id )
	VALUES ( 4, 2 )
	
	DELETE FROM Person_Address
	WHERE  owners_id = 1
	
	INSERT INTO Person_Address ( owners_id, addresses_id )
	VALUES ( 1, 3 )
	
###### 双向 many-to-many with a link entity

- 实体：

	@Entity(name = "Person")
	public static class Person implements Serializable {
	
	    @Id
	    @GeneratedValue
	    private Long id;
	
	    @NaturalId
	    private String registrationNumber;
	
	    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<PersonAddress> addresses = new ArrayList<>();
	
	    public Person() {
	    }
	
	    public Person(String registrationNumber) {
	        this.registrationNumber = registrationNumber;
	    }
	
	    public Long getId() {
	        return id;
	    }
	
	    public List<PersonAddress> getAddresses() {
	        return addresses;
	    }
	
	    public void addAddress(Address address) {
	        PersonAddress personAddress = new PersonAddress( this, address );
	        addresses.add( personAddress );
	        address.getOwners().add( personAddress );
	    }
	
	    public void removeAddress(Address address) {
	        PersonAddress personAddress = new PersonAddress( this, address );
	        address.getOwners().remove( personAddress );
	        addresses.remove( personAddress );
	        personAddress.setPerson( null );
	        personAddress.setAddress( null );
	    }
	
	    @Override
	    public boolean equals(Object o) {
	        if ( this == o ) {
	            return true;
	        }
	        if ( o == null || getClass() != o.getClass() ) {
	            return false;
	        }
	        Person person = (Person) o;
	        return Objects.equals( registrationNumber, person.registrationNumber );
	    }
	
	    @Override
	    public int hashCode() {
	        return Objects.hash( registrationNumber );
	    }
	}
	
	@Entity(name = "PersonAddress")
	public static class PersonAddress implements Serializable {
	
	    @Id
	    @ManyToOne
	    private Person person;
	
	    @Id
	    @ManyToOne
	    private Address address;
	
	    public PersonAddress() {
	    }
	
	    public PersonAddress(Person person, Address address) {
	        this.person = person;
	        this.address = address;
	    }
	
	    public Person getPerson() {
	        return person;
	    }
	
	    public void setPerson(Person person) {
	        this.person = person;
	    }
	
	    public Address getAddress() {
	        return address;
	    }
	
	    public void setAddress(Address address) {
	        this.address = address;
	    }
	
	    @Override
	    public boolean equals(Object o) {
	        if ( this == o ) {
	            return true;
	        }
	        if ( o == null || getClass() != o.getClass() ) {
	            return false;
	        }
	        PersonAddress that = (PersonAddress) o;
	        return Objects.equals( person, that.person ) &&
	                Objects.equals( address, that.address );
	    }
	
	    @Override
	    public int hashCode() {
	        return Objects.hash( person, address );
	    }
	}
	
	@Entity(name = "Address")
	public static class Address implements Serializable {
	
	    @Id
	    @GeneratedValue
	    private Long id;
	
	    private String street;
	
	    @Column(name = "`number`")
	    private String number;
	
	    private String postalCode;
	
	    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<PersonAddress> owners = new ArrayList<>();
	
	    public Address() {
	    }
	
	    public Address(String street, String number, String postalCode) {
	        this.street = street;
	        this.number = number;
	        this.postalCode = postalCode;
	    }
	
	    public Long getId() {
	        return id;
	    }
	
	    public String getStreet() {
	        return street;
	    }
	
	    public String getNumber() {
	        return number;
	    }
	
	    public String getPostalCode() {
	        return postalCode;
	    }
	
	    public List<PersonAddress> getOwners() {
	        return owners;
	    }
	
	    @Override
	    public boolean equals(Object o) {
	        if ( this == o ) {
	            return true;
	        }
	        if ( o == null || getClass() != o.getClass() ) {
	            return false;
	        }
	        Address address = (Address) o;
	        return Objects.equals( street, address.street ) &&
	                Objects.equals( number, address.number ) &&
	                Objects.equals( postalCode, address.postalCode );
	    }
	
	    @Override
	    public int hashCode() {
	        return Objects.hash( street, number, postalCode );
	    }
	}
	
- 生成sql：

	CREATE TABLE Address (
	    id BIGINT NOT NULL ,
	    number VARCHAR(255) ,
	    postalCode VARCHAR(255) ,
	    street VARCHAR(255) ,
	    PRIMARY KEY ( id )
	)
	
	CREATE TABLE Person (
	    id BIGINT NOT NULL ,
	    registrationNumber VARCHAR(255) ,
	    PRIMARY KEY ( id )
	)
	
	CREATE TABLE PersonAddress (
	    person_id BIGINT NOT NULL ,
	    address_id BIGINT NOT NULL ,
	    PRIMARY KEY ( person_id, address_id )
	)
	
	ALTER TABLE Person
	ADD CONSTRAINT UK_23enodonj49jm8uwec4i7y37f
	UNIQUE (registrationNumber)
	
	ALTER TABLE PersonAddress
	ADD CONSTRAINT FK8b3lru5fyej1aarjflamwghqq
	FOREIGN KEY (person_id) REFERENCES Person
	
	ALTER TABLE PersonAddress
	ADD CONSTRAINT FK7p69mgialumhegyl4byrh65jk
	FOREIGN KEY (address_id) REFERENCES Address
	
- 操作：

	Person person1 = new Person( "ABC-123" );
	Person person2 = new Person( "DEF-456" );
	
	Address address1 = new Address( "12th Avenue", "12A", "4005A" );
	Address address2 = new Address( "18th Avenue", "18B", "4007B" );
	
	entityManager.persist( person1 );
	entityManager.persist( person2 );
	
	entityManager.persist( address1 );
	entityManager.persist( address2 );
	
	person1.addAddress( address1 );
	person1.addAddress( address2 );
	
	person2.addAddress( address1 );
	
	entityManager.flush();
	
	log.info( "Removing address" );
	person1.removeAddress( address1 );
	---------------------------------------------------
	INSERT  INTO Person ( registrationNumber, id )
	VALUES  ( 'ABC-123', 1 )
	
	INSERT  INTO Person ( registrationNumber, id )
	VALUES  ( 'DEF-456', 2 )
	
	INSERT  INTO Address ( number, postalCode, street, id )
	VALUES  ( '12A', '4005A', '12th Avenue', 3 )
	
	INSERT  INTO Address ( number, postalCode, street, id )
	VALUES  ( '18B', '4007B', '18th Avenue', 4 )
	
	INSERT  INTO PersonAddress ( person_id, address_id )
	VALUES  ( 1, 3 )
	
	INSERT  INTO PersonAddress ( person_id, address_id )
	VALUES  ( 1, 4 )
	
	INSERT  INTO PersonAddress ( person_id, address_id )
	VALUES  ( 2, 3 )
	
	DELETE  FROM PersonAddress
	WHERE   person_id = 1 AND address_id = 3
	