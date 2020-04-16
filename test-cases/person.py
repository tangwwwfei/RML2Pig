from faker import Faker


def gen_persons_json(count: int):
    fake = Faker()
    persons = open("persons.json", "w")
    persons.write("""{
    "persons": [""")

    sstr = """
        {{
            "birthdate": "{0}",
            "company": "{1}",
            "email": "{2}",
            "height": {3},
            "id": {4},
            "name": "{5}",
            "phone": "{6}",
            "weight": {7}
        }},"""
    nstr = ""
    for i in range(0, count):
        persons.write(nstr)
        nstr = sstr.format(fake.date_of_birth(), fake.company(), fake.ascii_safe_email(), fake.random_int(), i,
                           fake.name(), fake.phone_number(), fake.random_int())
    nstr = nstr.rstrip(",")
    persons.write(nstr)
    persons.write("""
    ]
}    
""")
    persons.close()


def gen_persons_xml(count: int):
    fake = Faker()
    persons = open("persons.xml", "w")
    persons.write("""<?xml version="1.0"?>
<persons>""")

    sstr = """
    <person>
        <id>{0}</id>
        <name>{1}</name>
        <phone>{2}</phone>
        <email>{3}</email>
        <birthdate>{4}</birthdate>
        <height>{5}</height>
        <weight>{6}</weight>
        <company>{7}</company>
    </person>"""
    nstr = ""
    for i in range(0, count):
        nstr = sstr.format(i, fake.name(), fake.phone_number(), fake.ascii_safe_email(), fake.date_of_birth(),
                           fake.random_int(), fake.random_int(), fake.company())
        persons.write(nstr)
    persons.write("""
</persons>""")
    persons.close()


def gen_persons_csv(count: int):
    fake = Faker()
    persons = open("persons.csv", "w")
    persons.write("""PersonId,Name,Phone,Email,Birthdate,Height,Weight,Company""")

    sstr = """
{0},{1},{2},{3},{4},{5},{6},{7}"""
    nstr = ""
    for i in range(0, count):
        nstr = sstr.format(i, fake.name(), fake.phone_number(), fake.ascii_safe_email(), fake.date_of_birth(),
                           fake.random_int(), fake.random_int(), fake.company())
        persons.write(nstr)
    persons.close()
