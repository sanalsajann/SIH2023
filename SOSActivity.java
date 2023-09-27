 public class EmergencyNumbersManager {
    // Implement methods to add, edit, delete, and retrieve emergency numbers.
}
public class LocationTracker {
    // Implement location tracking logic.
}
public class SOSActivity extends AppCompatActivity {

    private EmergencyNumbersManager numbersManager;
    private LocationTracker locationTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);

        numbersManager = new EmergencyNumbersManager();
        locationTracker = new LocationTracker();
    }

    public void onSOSButtonClick(View view) {
        List<String> emergencyNumbers = numbersManager.getEmergencyNumbers();
        String currentLocation = locationTracker.getCurrentLocation();

        for (String number : emergencyNumbers) {
            makeEmergencyCall(number);
            sendLocationToAuthorities(currentLocation);
        }
    }

    private void makeEmergencyCall(String number) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            startActivity(intent);
        }
    }

    private void sendLocationToAuthorities(String location) {
        // Implement logic to send location data to the authorities via SMS, email, or a web service.
    }
}
