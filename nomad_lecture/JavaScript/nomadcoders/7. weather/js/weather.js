function onGeoOk(position) {
  console.log(position)
  const lat = position.coords.latitude
  const lng = position.coords.longitude
  console.log(lat, lng)
}

function onGeoError() {
  alert("can't find you. No weather for you")
}


navigator.geolocation.getCurrentPosition(onGeoOk, onGeoError)