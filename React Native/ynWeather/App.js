import { StatusBar } from 'expo-status-bar';
import { View } from 'react-native';

export default function App() {
  return (
    // 보모의 flex는 필수
    <View style={{ flex: 1 }}>
      {/* 3개의 view 크기를 비율로 조절 가능 */}
      <View style={{flex: 5, backgroundColor:"tomato"}}></View>
      <View style={{flex: 3, backgroundColor:"teal"}}></View>
      <View style={{flex: 1, backgroundColor:"orange"}}></View>
    </View>
  );
}

