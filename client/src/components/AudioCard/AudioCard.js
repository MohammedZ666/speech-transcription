import React, { useState, useRef } from "react";
import "./AudioCard.css";
import Slider from "./Slider/Slider";
// import song from "../../chimes-7035.mp3";
import ControlPanel from "./Controls/ControlPanel";
import { useNavigate } from "react-router-dom";
import { getServerUrl } from "../../utils/CRUD";

const AudioCard = ({ id, transcript, fileUri }) => {
  const navigate = useNavigate();

  const [percentage, setPercentage] = useState(0);
  const [isPlaying, setIsPlaying] = useState(false);
  const [duration, setDuration] = useState(0);
  const [currentTime, setCurrentTime] = useState(0);

  const audioRef = useRef();

  const onChange = (e) => {
    const audio = audioRef.current;
    audio.currentTime = (audio.duration / 100) * e.target.value;
    setPercentage(e.target.value);
  };

  const play = () => {
    const audio = audioRef.current;
    audio.volume = 0.1;

    if (!isPlaying) {
      setIsPlaying(true);
      audio.play();
    }

    if (isPlaying) {
      setIsPlaying(false);
      audio.pause();
    }
  };

  const getCurrDuration = (e) => {
    const percent = (
      (e.currentTarget.currentTime / e.currentTarget.duration) *
      100
    ).toFixed(2);
    const time = e.currentTarget.currentTime;

    setPercentage(+percent);
    setCurrentTime(time.toFixed(2));
  };

  const handleSubmit = (e) => {
    navigate("/edit", {
      state: {
        id: id
      }
    });
  };

  return (
    <div className="app-container" style={{ marginLeft: "196px" }}>
      <Slider onChange={onChange} percentage={percentage} />
      <audio
        ref={audioRef}
        onTimeUpdate={getCurrDuration}
        onLoadedData={(e) => {
          setDuration(e.currentTarget.duration.toFixed(2));
        }}
        src={getServerUrl() + "/file/" + fileUri}
      ></audio>
      <p>{transcript}</p>
      <ControlPanel
        play={play}
        isPlaying={isPlaying}
        duration={duration}
        currentTime={currentTime}
      />
      <button className="button" onClick={handleSubmit}>
        Edit
      </button>
    </div>
  );
};

export default AudioCard;
