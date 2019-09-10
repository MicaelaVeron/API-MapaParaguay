package com.example.mapa_paraguay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Tile;

import java.util.Locale;

import static com.google.android.gms.maps.GoogleMap.*;

public class MapsActivity1 extends AppCompatActivity implements GoogleMap.OnMarkerDragListener ,OnMapReadyCallback, GoogleMap.OnMarkerClickListener{

    private GoogleMap mMap;
    private  Marker markerPrueba; //agregamos el marcador
    private Marker marker2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps1);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //codigos por defecto de google
        // se coloca la latitud y longitud de las ciudade
        LatLng asuncion = new LatLng(-25.2800459, -57.6343814);
        // se coloca un titulo y una descripcion
        mMap.addMarker(new MarkerOptions().position(asuncion).draggable(true).title("Ciudad de Asuncion").snippet("Descripcion").icon(BitmapDescriptorFactory.fromResource(R.drawable.bunker)));

        //chaco
        LatLng chaco = new LatLng(-24.0860442, -54.9410211);
        // se coloca un titulo y una descripcion
        mMap.addMarker(new MarkerOptions().position(chaco).draggable(true).title("Chaco").snippet("Descripcion").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));

        //caacupe
        LatLng caacupe = new LatLng(-25.3855654, -57.1401431);
        // se coloca un titulo y una descripcion
        mMap.addMarker(new MarkerOptions().position(caacupe).draggable(true).title("Caacupe").snippet("Descripcion").icon(BitmapDescriptorFactory.fromResource(R.drawable.manole)));

        //marcador prueba
        LatLng prueba = new LatLng(-25.7809839, -56.4478765);
        //creamos un nuevo marcador
        markerPrueba = googleMap.addMarker((new MarkerOptions().position(prueba).draggable(true).title("Prueba")));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(asuncion,7));
        //para poder utilizar eventos
        googleMap.setOnMarkerClickListener(this);
        googleMap.setOnMarkerDragListener(this);

        //marcador2,si se quiere trabajar con eventos, se debe crear um propio marcador
        LatLng marcador2 = new LatLng(-25.5169015, -54.6168645);
        marker2 = googleMap.addMarker((new MarkerOptions().position(marcador2).draggable(true).title("Marcador2").draggable(true)));


    }
//agregamos el metodo googlemap.onMarkerclicklistener,se utiliza para los marcadores,etc
    @Override
    public boolean onMarkerClick(Marker marker) {
        //muestra el mensaje el mensaje al pulsar el marcador
        if(marker.equals(markerPrueba)){
            String lat,longi;
            lat = Double.toString(marker.getPosition().latitude); // latitud del nuevo marcador
            longi = Double.toHexString(marker.getPosition().longitude); //lomgitud del nuevo marcador
            Toast.makeText(this,lat +","+ longi,Toast.LENGTH_LONG).show();
        }
        return false;
    }
    //drag listener
    @Override
    public void onMarkerDragStart(Marker marker) {
        if(marker.equals(marker2)){
            Toast.makeText(this,"Start" ,Toast.LENGTH_LONG).show();

        }

    }

    @Override
    public void onMarkerDrag(Marker marker) {
        String  newTitle = String.format(Locale.getDefault(),getString(R.string.marker_detail_lating),marker.getPosition().latitude,marker.getPosition().longitude);
        setTitle(newTitle);

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        if(marker.equals(marker2)){
            Toast.makeText(this,"Finish" ,Toast.LENGTH_LONG).show();
            setTitle(R.string.sitios);


        }

    }
}
