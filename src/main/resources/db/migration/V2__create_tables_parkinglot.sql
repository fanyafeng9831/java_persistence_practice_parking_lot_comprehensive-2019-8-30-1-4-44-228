CREATE TABLE `parkinglot` (
  `parkinglotId` INTEGER PRIMARY KEY,
  `parkinglotCapacity` int(11) NOT NULL,
  `parkinglotAvailablePositionCount` int(11) NOT NULL,
  `parkingboyId` INTEGER NOT NULL,
--   FOREIGN KEY(parkingboyId) REFERENCES parkingboy(parkingboyId)
);

