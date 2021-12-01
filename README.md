# Labb-2--Students

Då jag lägger till lärare och studenter i en separat klass (SampleDataGenerator) och inte i create metoderna i service-klasserna, behöver man inte nödvändigtvist skapa entiteterna innan de skrivs ut, därmed är den ända endpointen som behövs: 
http://localhost:8080/student-management-system/api/v1/subjects

Då ska man få ut detta: 
[
  {
    "id": 1,
    "name": "Math",
    "students": [
      {
        "email": "pelle@elev.se",
        "firstName": "Pelle",
        "id": 2,
        "lastName": "Persson",
        "phoneNumber": "0709876544"
      },
      {
        "email": "nika@elev.se",
        "firstName": "Nika",
        "id": 5,
        "lastName": "Arya",
        "phoneNumber": "0709876543"
      }
    ],
    "teacher": {
      "firstName": "Hanna",
      "id": 6,
      "lastName": "Svensson",
      "mainSubject": "Social science"
    }
  },
  {
    "id": 3,
    "name": "Science",
    "students": [
      {
        "email": "pelle@elev.se",
        "firstName": "Pelle",
        "id": 2,
        "lastName": "Persson",
        "phoneNumber": "0709876544"
      },
      {
        "email": "per@elev.se",
        "firstName": "Per",
        "id": 4,
        "lastName": "Andersson",
        "phoneNumber": "0701234567"
      },
      {
        "email": "nika@elev.se",
        "firstName": "Nika",
        "id": 5,
        "lastName": "Arya",
        "phoneNumber": "0709876543"
      }
    ],
    "teacher": {
      "firstName": "Malin",
      "id": 7,
      "lastName": "Persson",
      "mainSubject": "Swedish"
    }
  }
]
Har även testat att i klassen SampleDataGenerator lägga till fler lärare till ett ämne vilket inte fungerar, vilket är bra då ett ämne endast ska kunna ha en lärare.