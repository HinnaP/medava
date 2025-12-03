package edu.uc.cs3003.medava;

public class Hospital {

    private String name;

    public Hospital(String hospitalName) {
        this.name = hospitalName;
    }

    void receive(Transporter transporter) {
        while (!transporter.isEmpty()) {

            Shippable item = transporter.unload();
            String medName = item.getMedicineName();
            MedicineSchedule schedule = item.getSchedule();

            System.out.println(String.format(
                    "Checking whether Hospital can receive %s.",
                    medName));

            boolean isUncontrolled = (schedule == MedicineSchedule.Uncontrolled);

            if (isUncontrolled) {
                System.out.println(String.format(
                        "Accepted a shipment of %s.",
                        medName));
            } else {
                System.out.println(String.format(
                        "Hospital cannot receive controlled substances and %s is a %s.",
                        medName,
                        schedule.asString()));
            }
        }
    }

    public String name() {
        return name;
    }
}
