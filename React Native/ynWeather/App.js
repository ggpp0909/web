import { StatusBar } from 'expo-status-bar';
import { useEffect, useState } from 'react';
import { View, StyleSheet, Text, ScrollView, Dimensions } from 'react-native';
import * as Location from 'expo-location';

const { height:SCREEN_HEIGHT, width:SCREEN_WIDTH } = Dimensions.get("window");

export default function App() {
  const [city, setCity] = useState("Loading...");
  const [location, setLocation] = useState();
  const [ok, setOk] = useState(true);
  const ask = async () => {
    const { greated } = await Location.requestForegroundPermissionsAsync();
    // console.log(permission) {"canAskAgain": true, "expires": "never", "granted": true, "status": "granted"}
    // 위치 정보 사용을 허가 받았다면 api요청, 아니라면 state변경, ui 변경
    if (!greated) {
      setOk(false)
    }
    const { coords: { latitude, longitude } } = await Location.getCurrentPositionAsync({ accuracy: 5 })
    // console.log(location) 방향 고도 위도 등등 많은정보 있음
    const location = await Location.reverseGeocodeAsync({ latitude, longitude }, { useGoogleMaps: false })
    // console.log(location)
    // console.log(location[0].city)
    setCity(location[0].city)
  }
  useEffect(() => { 
    ask()
  }, [])

  return (
    <View style={styles.container}>
      <View style={styles.city}>
        <Text style={styles.cityName}>{ city }</Text>
      </View>
      <ScrollView showsHorizontalScrollIndicator={false} pagingEnabled horizontal contentContainerStyle={styles.weather}>
        <View style={styles.day}>
          <Text style={styles.temp}>12</Text>
          <Text style={styles.description}>Sunny</Text>
        </View>
        <View style={styles.day}>
          <Text style={styles.temp}>12</Text>
          <Text style={styles.description}>Sunny</Text>
        </View>
        <View style={styles.day}>
          <Text style={styles.temp}>12</Text>
          <Text style={styles.description}>Sunny</Text>
        </View>
        <View style={styles.day}>
          <Text style={styles.temp}>12</Text>
          <Text style={styles.description}>Sunny</Text>
        </View>
      </ScrollView>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1, backgroundColor: "tomato"
  },
  city: {
    flex: 1.2,
    justifyContent: "center",
    alignItems: "center"
  },
  cityName: {
    fontSize: 68,
    fontWeight: "500"
  },
  weather: {

  },
  day: {
    width: SCREEN_WIDTH,
    alignItems: "center",
  },
  temp: {
    fontSize: 168,
    marginTop: 50,
  },
  description: {
    marginTop: -30,
    fontSize: 60
  },

})
