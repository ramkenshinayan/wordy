import sys, WordyModule
import threading
import time
import datetime
from omniORB import CORBA
import CosNaming

username = ""
roundTimer = None
wordSubmitted = False

def login():
    global username

    print("----LOGIN----")
    while True:
        try:
            username_input = raw_input("Enter Username: ")
            password_input = raw_input("Enter Password: ")
            wordyGame.login(username_input, password_input)
            username = username_input
            main_menu()
        except WordyModule.InvalidLoginException as ex:
            print(ex.reason)
            login()


def main_menu():
    global username

    while True:
        print("\nWELCOME TO WORDY! " + username)
        print("-----------Wordy App----------")
        print("| 1. Initiate/Join Game      |")
        print("| 2. Show Leaderboards       |")
        print("| 3. Logout                  |")
        print("------------------------------")
        choice = raw_input("Input Choice: ")

        if not choice.isdigit():
            print("Invalid input. Please enter a number.")
            continue

        choice = int(choice)

        if choice == 1:
            initiate_game()
            pass
        elif choice == 2:
            leaderboard_menu()
            pass
        elif choice == 3:
            log_out();
            pass
        else:
            print("Please enter a number from the menu")


def initiate_game():
    global roundTimer, wordSubmitted
    print("Waiting for players...")
    try:
        wordyGame.initiateGame(username)
    except WordyModule.NotEnoughPlayers as ex:
        print(ex.reason)
        return

    print("Game started!")

    letters = wordyGame.getLetters(username)
    print("Letters: " + letters)

    roundTimer = threading.Timer(10.0, end_round)
    roundTimer.start()

    while roundTimer.is_alive():
        if not wordSubmitted:
            submit()
            time.sleep(1)

    # Check if the round timer ended but no word was submitted
    if not wordSubmitted:
        print("No word submitted. Ending the round...")
        try:
            wordyGame.roundEndFlag(username)  # Call the roundEndFlag() method
        except WordyModule.NoWinnerException as ex:
            print(ex.reason)

    # Reset the wordSubmitted flag for the next round
    wordSubmitted = False

    # Wait for a moment before proceeding to the next round
    time.sleep(2)

    # Check if the game is over
    players = wordyGame.getAllPlayers(username)
    for player in players:
        if player.roundWins == 3:
            print("Game over. Winner: " + wordyGame.getGameWinner(username))
            printPlayers()
            return





def check_round_end_flag():
    while True:
        if wordyGame.roundEndFlag(username):
            display_round_winner()
            new_round()
        time.sleep(1)


def waiting_time_display():
    def timer():
        global timeLeft, wordSubmitted
        while timeLeft > 0:
            time.sleep(1)
            timeLeft -= 1

        if not wordSubmitted:
            print("Time's up! Ending the round...")
            wordyGame.roundEndFlag(username)  # Call the roundEndFlag() method

        # Reset the wordSubmitted flag for the next round
        wordSubmitted = False
        timeLeft = 10

def startNewRoundTimerDisplay():
    timer_duration = 5
    while timer_duration > 0:
        print(timer_duration)
        timer_duration -= 1
        time.sleep(1)


def timer():
    time_remaining = wordyGame.getTime(username)
    while time_remaining > 0:
        print(time_remaining)
        time_remaining -= 1
        time.sleep(1)

def printPlayers():
    players = wordyGame.getAllPlayers(username)
    print("------------------------------------------")
    print("|     Username      |        Score       |")
    print("------------------------------------------")
    for player in players:
        print("|    %-15s |       %-10d  |" % (player.username, player.roundWins))
    print("------------------------------------------")

def submit():
    global wordSubmitted
    word = raw_input("Submit word: ").upper()
    try:
        wordyGame.submitWord(username, word)
        print("Word is valid!")
        wordSubmitted = True
    except WordyModule.InvalidWordException as ex:
        print(ex.reason)



def end_round():
    global wordSubmitted
    if not wordSubmitted:
        print("Time's up! Ending the round...")
        wordyGame.roundEndFlag(username)
    wordSubmitted = False
    new_round()

def new_round():
    global roundTimer
    roundTimer = threading.Timer(10.0, end_round)
    roundTimer.start()
    print("Waiting for the next round to start...")
    countdown(5)  # Adjust the countdown duration as needed
    printPlayers()
    letters = wordyGame.getLetters(username)
    print("Letters: " + letters)

def countdown(seconds):
    for i in range(seconds, 0, -1):
        print(i)
        sys.stdout.flush()
        time.sleep(1)


def display_round_winner():
    try:
        winner = wordyGame.getRoundWinner(username)
        print("Round has ended....")
        print("Round winner: " + winner.username)
    except WordyModule.NoWinnerException as e:
        print(e.reason)


def leaderboard_menu():
    while True:
        print("\nLeaderboard Menu:")
        print("----------Leaderboard---------")
        print("| 1. Top 5 Players           |")
        print("| 2. Top 5 Longest Words     |")
        print("| 3. Return                  |")
        print("------------------------------")
        choice = raw_input("Input Choice: ")

        if not choice.isdigit():
            print("Please enter a valid number")
            continue

        choice = int(choice)

        if choice == 1:
            display_top_players()
        elif choice == 2:
            display_top_longest_words()
        elif choice == 3:
            return
        else:
            print("Please enter a valid number")


def display_top_longest_words():
    total_entries = wordyGame.getLongestWordsSize()
    limit = min(5, total_entries)

    # Print header
    print("--------------------------------------------------------------")
    print("| {:<15s} | {:<15s} | {:<10s} | {:<6s} |".format("Username", "Word", "Count", "Ranking"))
    print("--------------------------------------------------------------")
    for i in range(limit):
        longest_word = wordyGame.getLongestWord(i)
        # Print details with ranking
        rank = i + 1
        print("| {:<15s} | {:<15s} | {:<10d} | {:<6d} |".format(longest_word.username,
                                                                longest_word.word,
                                                                longest_word.letterCount,
                                                                rank))
    # Print footer
    print("--------------------------------------------------------------")


def display_top_players():
    total_entries = wordyGame.getTopPlayersSize()
    limit = min(5, total_entries)
    # Print header
    print("--------------------------------------------------------------")
    print("| {:<15s} | {:<15s} | {:<10s} | {:<6s} |".format("Username", "Round Wins", "Game Wins", "Ranking"))
    print("--------------------------------------------------------------")
    for i in range(limit):
        player = wordyGame.getTopPlayers(i)
        # Print details with ranking
        rank = i + 1
        print("| {:<15s} | {:<15d} | {:<10d} | {:<6d} |".format(player.username,
                                                                player.roundWins,
                                                                player.gameWins,
                                                                rank))
    # Print footer
    print("--------------------------------------------------------------")



def log_out():
    global username

    print("Are you sure?")
    print("1. Yes")
    print("2. No")
    choice = raw_input("Input Choice: ")

    if not choice.isdigit():
        print("Please enter a valid number")

    choice = int(choice)

    if choice == 1:
        print("Logged out...")
        wordyGame.logout(username)
        login()
    elif choice == 2:
        return
    else:
        print("Please enter a valid number")
    pass


orb = CORBA.ORB_init(sys.argv, CORBA.ORB_ID)
obj = orb.string_to_object("corbaloc:iiop:localhost:1050/NameService")
ncRef = obj._narrow(CosNaming.NamingContext)
name = [CosNaming.NameComponent("Wordy", "")]
obj = ncRef.resolve(name)
wordyGame = obj._narrow(WordyModule.Wordy)

login()
