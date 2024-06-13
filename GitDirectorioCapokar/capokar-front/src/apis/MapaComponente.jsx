// src/components/MapComponent.jsx
import React from 'react';
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet';
import L from 'leaflet';

// Importar imágenes directamente desde node_modules
import markerIcon2x from 'leaflet/dist/images/marker-icon-2x.png';
import markerIcon from 'leaflet/dist/images/marker-icon.png';
import markerShadow from 'leaflet/dist/images/marker-shadow.png';

// Configurar los iconos de Leaflet
L.Icon.Default.mergeOptions({
});

const MapaComponente = ({ejex,ejey}) => {
  const position = [ejex, ejey]; // Coordenadas de la ubicación

  return (
    <MapContainer center={position} zoom={20} style={{ height: "100%", width: "100%" }}>
      <TileLayer
        url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
        attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
      />
      <Marker position={position}>
        <Popup>
          Aqui se ubica Capokar <br /> Codigo Postal: 09921 Numero de local: 11
        </Popup>
      </Marker>
    </MapContainer>
  );
};

export default MapaComponente;
