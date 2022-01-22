def favGenres(userVideos, videoGenres):
    favoriteGenres = {}

    for user in userVideos:
        videos = userVideos[user]
        genreCount = {}

        for video in videos:
            for genre in videoGenres:
                if video in videoGenres[genre]:
                    genreCount[genre] = genreCount.get(genre, 0) + 1
        
        favoriteGenres[user] = [key for key, value in genreCount.items() if value == max(genreCount.values())]
    
    return favoriteGenres


userSongs = {  
    "David": ["song1", "song2", "song3", "song4", "song8"],
    "Emma":  ["song5", "song6", "song7"]
}

songGenres = {  
    "Rock":    ["song1", "song3"],
    "Dubstep": ["song7"],
    "Techno":  ["song2", "song4"],
    "Pop":     ["song5", "song6"],
    "Jazz":    ["song8", "song9"]
}

print(favGenres(userSongs, songGenres))