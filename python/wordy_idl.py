# Python stubs generated by omniidl from wordy.idl
# DO NOT EDIT THIS FILE!

import omniORB, _omnipy
from omniORB import CORBA, PortableServer
_0_CORBA = CORBA


_omnipy.checkVersion(4,2, __file__, 1)

try:
    property
except NameError:
    def property(*args):
        return None


#
# Start of module "WordyModule"
#
__name__ = "WordyModule"
_0_WordyModule = omniORB.openModule("WordyModule", r"wordy.idl")
_0_WordyModule__POA = omniORB.openModule("WordyModule__POA", r"wordy.idl")


# typedef ... Letters
class Letters:
    _NP_RepositoryId = "IDL:WordyModule/Letters:1.0"
    def __init__(self, *args, **kw):
        raise RuntimeError("Cannot construct objects of this type.")
_0_WordyModule.Letters = Letters
_0_WordyModule._d_Letters  = (omniORB.tcInternal.tv_sequence, omniORB.tcInternal.tv_char, 0)
_0_WordyModule._ad_Letters = (omniORB.tcInternal.tv_alias, Letters._NP_RepositoryId, "Letters", (omniORB.tcInternal.tv_sequence, omniORB.tcInternal.tv_char, 0))
_0_WordyModule._tc_Letters = omniORB.tcInternal.createTypeCode(_0_WordyModule._ad_Letters)
omniORB.registerType(Letters._NP_RepositoryId, _0_WordyModule._ad_Letters, _0_WordyModule._tc_Letters)
del Letters

# struct Player_
_0_WordyModule.Player_ = omniORB.newEmptyClass()
class Player_ (omniORB.StructBase):
    _NP_RepositoryId = "IDL:WordyModule/Player_:1.0"

    def __init__(self, username, roundWins):
        self.username = username
        self.roundWins = roundWins

_0_WordyModule.Player_ = Player_
_0_WordyModule._d_Player_  = (omniORB.tcInternal.tv_struct, Player_, Player_._NP_RepositoryId, "Player_", "username", (omniORB.tcInternal.tv_string,0), "roundWins", omniORB.tcInternal.tv_long)
_0_WordyModule._tc_Player_ = omniORB.tcInternal.createTypeCode(_0_WordyModule._d_Player_)
omniORB.registerType(Player_._NP_RepositoryId, _0_WordyModule._d_Player_, _0_WordyModule._tc_Player_)
del Player_

# typedef ... PlayerList
class PlayerList:
    _NP_RepositoryId = "IDL:WordyModule/PlayerList:1.0"
    def __init__(self, *args, **kw):
        raise RuntimeError("Cannot construct objects of this type.")
_0_WordyModule.PlayerList = PlayerList
_0_WordyModule._d_PlayerList  = (omniORB.tcInternal.tv_sequence, omniORB.typeMapping["IDL:WordyModule/Player_:1.0"], 0)
_0_WordyModule._ad_PlayerList = (omniORB.tcInternal.tv_alias, PlayerList._NP_RepositoryId, "PlayerList", (omniORB.tcInternal.tv_sequence, omniORB.typeMapping["IDL:WordyModule/Player_:1.0"], 0))
_0_WordyModule._tc_PlayerList = omniORB.tcInternal.createTypeCode(_0_WordyModule._ad_PlayerList)
omniORB.registerType(PlayerList._NP_RepositoryId, _0_WordyModule._ad_PlayerList, _0_WordyModule._tc_PlayerList)
del PlayerList

# struct RoundWinner_
_0_WordyModule.RoundWinner_ = omniORB.newEmptyClass()
class RoundWinner_ (omniORB.StructBase):
    _NP_RepositoryId = "IDL:WordyModule/RoundWinner_:1.0"

    def __init__(self, name, winningWord, roundWins):
        self.name = name
        self.winningWord = winningWord
        self.roundWins = roundWins

_0_WordyModule.RoundWinner_ = RoundWinner_
_0_WordyModule._d_RoundWinner_  = (omniORB.tcInternal.tv_struct, RoundWinner_, RoundWinner_._NP_RepositoryId, "RoundWinner_", "name", (omniORB.tcInternal.tv_string,0), "winningWord", (omniORB.tcInternal.tv_string,0), "roundWins", omniORB.tcInternal.tv_long)
_0_WordyModule._tc_RoundWinner_ = omniORB.tcInternal.createTypeCode(_0_WordyModule._d_RoundWinner_)
omniORB.registerType(RoundWinner_._NP_RepositoryId, _0_WordyModule._d_RoundWinner_, _0_WordyModule._tc_RoundWinner_)
del RoundWinner_

# struct TopLongestWord
_0_WordyModule.TopLongestWord = omniORB.newEmptyClass()
class TopLongestWord (omniORB.StructBase):
    _NP_RepositoryId = "IDL:WordyModule/TopLongestWord:1.0"

    def __init__(self, username, word, letterCount):
        self.username = username
        self.word = word
        self.letterCount = letterCount

_0_WordyModule.TopLongestWord = TopLongestWord
_0_WordyModule._d_TopLongestWord  = (omniORB.tcInternal.tv_struct, TopLongestWord, TopLongestWord._NP_RepositoryId, "TopLongestWord", "username", (omniORB.tcInternal.tv_string,0), "word", (omniORB.tcInternal.tv_string,0), "letterCount", omniORB.tcInternal.tv_long)
_0_WordyModule._tc_TopLongestWord = omniORB.tcInternal.createTypeCode(_0_WordyModule._d_TopLongestWord)
omniORB.registerType(TopLongestWord._NP_RepositoryId, _0_WordyModule._d_TopLongestWord, _0_WordyModule._tc_TopLongestWord)
del TopLongestWord

# struct TopPlayer
_0_WordyModule.TopPlayer = omniORB.newEmptyClass()
class TopPlayer (omniORB.StructBase):
    _NP_RepositoryId = "IDL:WordyModule/TopPlayer:1.0"

    def __init__(self, username, roundWins, gameWins):
        self.username = username
        self.roundWins = roundWins
        self.gameWins = gameWins

_0_WordyModule.TopPlayer = TopPlayer
_0_WordyModule._d_TopPlayer  = (omniORB.tcInternal.tv_struct, TopPlayer, TopPlayer._NP_RepositoryId, "TopPlayer", "username", (omniORB.tcInternal.tv_string,0), "roundWins", omniORB.tcInternal.tv_long, "gameWins", omniORB.tcInternal.tv_long)
_0_WordyModule._tc_TopPlayer = omniORB.tcInternal.createTypeCode(_0_WordyModule._d_TopPlayer)
omniORB.registerType(TopPlayer._NP_RepositoryId, _0_WordyModule._d_TopPlayer, _0_WordyModule._tc_TopPlayer)
del TopPlayer

# exception InvalidLoginException
_0_WordyModule.InvalidLoginException = omniORB.newEmptyClass()
class InvalidLoginException (CORBA.UserException):
    _NP_RepositoryId = "IDL:WordyModule/InvalidLoginException:1.0"

    def __init__(self, reason):
        CORBA.UserException.__init__(self, reason)
        self.reason = reason

_0_WordyModule.InvalidLoginException = InvalidLoginException
_0_WordyModule._d_InvalidLoginException  = (omniORB.tcInternal.tv_except, InvalidLoginException, InvalidLoginException._NP_RepositoryId, "InvalidLoginException", "reason", (omniORB.tcInternal.tv_string,0))
_0_WordyModule._tc_InvalidLoginException = omniORB.tcInternal.createTypeCode(_0_WordyModule._d_InvalidLoginException)
omniORB.registerType(InvalidLoginException._NP_RepositoryId, _0_WordyModule._d_InvalidLoginException, _0_WordyModule._tc_InvalidLoginException)
del InvalidLoginException

# exception NotEnoughPlayers
_0_WordyModule.NotEnoughPlayers = omniORB.newEmptyClass()
class NotEnoughPlayers (CORBA.UserException):
    _NP_RepositoryId = "IDL:WordyModule/NotEnoughPlayers:1.0"

    def __init__(self, reason):
        CORBA.UserException.__init__(self, reason)
        self.reason = reason

_0_WordyModule.NotEnoughPlayers = NotEnoughPlayers
_0_WordyModule._d_NotEnoughPlayers  = (omniORB.tcInternal.tv_except, NotEnoughPlayers, NotEnoughPlayers._NP_RepositoryId, "NotEnoughPlayers", "reason", (omniORB.tcInternal.tv_string,0))
_0_WordyModule._tc_NotEnoughPlayers = omniORB.tcInternal.createTypeCode(_0_WordyModule._d_NotEnoughPlayers)
omniORB.registerType(NotEnoughPlayers._NP_RepositoryId, _0_WordyModule._d_NotEnoughPlayers, _0_WordyModule._tc_NotEnoughPlayers)
del NotEnoughPlayers

# exception NoWinnerException
_0_WordyModule.NoWinnerException = omniORB.newEmptyClass()
class NoWinnerException (CORBA.UserException):
    _NP_RepositoryId = "IDL:WordyModule/NoWinnerException:1.0"

    def __init__(self, reason):
        CORBA.UserException.__init__(self, reason)
        self.reason = reason

_0_WordyModule.NoWinnerException = NoWinnerException
_0_WordyModule._d_NoWinnerException  = (omniORB.tcInternal.tv_except, NoWinnerException, NoWinnerException._NP_RepositoryId, "NoWinnerException", "reason", (omniORB.tcInternal.tv_string,0))
_0_WordyModule._tc_NoWinnerException = omniORB.tcInternal.createTypeCode(_0_WordyModule._d_NoWinnerException)
omniORB.registerType(NoWinnerException._NP_RepositoryId, _0_WordyModule._d_NoWinnerException, _0_WordyModule._tc_NoWinnerException)
del NoWinnerException

# exception InvalidWordException
_0_WordyModule.InvalidWordException = omniORB.newEmptyClass()
class InvalidWordException (CORBA.UserException):
    _NP_RepositoryId = "IDL:WordyModule/InvalidWordException:1.0"

    def __init__(self, reason):
        CORBA.UserException.__init__(self, reason)
        self.reason = reason

_0_WordyModule.InvalidWordException = InvalidWordException
_0_WordyModule._d_InvalidWordException  = (omniORB.tcInternal.tv_except, InvalidWordException, InvalidWordException._NP_RepositoryId, "InvalidWordException", "reason", (omniORB.tcInternal.tv_string,0))
_0_WordyModule._tc_InvalidWordException = omniORB.tcInternal.createTypeCode(_0_WordyModule._d_InvalidWordException)
omniORB.registerType(InvalidWordException._NP_RepositoryId, _0_WordyModule._d_InvalidWordException, _0_WordyModule._tc_InvalidWordException)
del InvalidWordException

# interface Wordy
_0_WordyModule._d_Wordy = (omniORB.tcInternal.tv_objref, "IDL:WordyModule/Wordy:1.0", "Wordy")
omniORB.typeMapping["IDL:WordyModule/Wordy:1.0"] = _0_WordyModule._d_Wordy
_0_WordyModule.Wordy = omniORB.newEmptyClass()
class Wordy :
    _NP_RepositoryId = _0_WordyModule._d_Wordy[1]

    def __init__(self, *args, **kw):
        raise RuntimeError("Cannot construct objects of this type.")

    _nil = CORBA.Object._nil


_0_WordyModule.Wordy = Wordy
_0_WordyModule._tc_Wordy = omniORB.tcInternal.createTypeCode(_0_WordyModule._d_Wordy)
omniORB.registerType(Wordy._NP_RepositoryId, _0_WordyModule._d_Wordy, _0_WordyModule._tc_Wordy)

# Wordy operations and attributes
Wordy._d_login = (((omniORB.tcInternal.tv_string,0), (omniORB.tcInternal.tv_string,0)), (), {_0_WordyModule.InvalidLoginException._NP_RepositoryId: _0_WordyModule._d_InvalidLoginException})
Wordy._d_logout = (((omniORB.tcInternal.tv_string,0), ), (), None)
Wordy._d_initiateGame = (((omniORB.tcInternal.tv_string,0), ), (), {_0_WordyModule.NotEnoughPlayers._NP_RepositoryId: _0_WordyModule._d_NotEnoughPlayers})
Wordy._d_submitWord = (((omniORB.tcInternal.tv_string,0), (omniORB.tcInternal.tv_string,0)), (), {_0_WordyModule.InvalidWordException._NP_RepositoryId: _0_WordyModule._d_InvalidWordException})
Wordy._d_getGameWinner = (((omniORB.tcInternal.tv_string,0), ), ((omniORB.tcInternal.tv_string,0), ), None)
Wordy._d_getAllPlayers = (((omniORB.tcInternal.tv_string,0), ), (omniORB.typeMapping["IDL:WordyModule/PlayerList:1.0"], ), None)
Wordy._d_getRoundWinner = (((omniORB.tcInternal.tv_string,0), ), (omniORB.typeMapping["IDL:WordyModule/RoundWinner_:1.0"], ), {_0_WordyModule.NoWinnerException._NP_RepositoryId: _0_WordyModule._d_NoWinnerException})
Wordy._d_getLetters = (((omniORB.tcInternal.tv_string,0), ), (omniORB.typeMapping["IDL:WordyModule/Letters:1.0"], ), None)
Wordy._d_getTime = (((omniORB.tcInternal.tv_string,0), ), (omniORB.tcInternal.tv_long, ), None)
Wordy._d_getLongestWord = ((omniORB.tcInternal.tv_long, ), (omniORB.typeMapping["IDL:WordyModule/TopLongestWord:1.0"], ), None)
Wordy._d_getLongestWordsSize = ((), (omniORB.tcInternal.tv_long, ), None)
Wordy._d_getTopPlayers = ((omniORB.tcInternal.tv_long, ), (omniORB.typeMapping["IDL:WordyModule/TopPlayer:1.0"], ), None)
Wordy._d_getTopPlayersSize = ((), (omniORB.tcInternal.tv_long, ), None)
Wordy._d_disposeGame = (((omniORB.tcInternal.tv_string,0), ), (), None)
Wordy._d_gameStartFlag = (((omniORB.tcInternal.tv_string,0), ), (omniORB.tcInternal.tv_boolean, ), None)
Wordy._d_gameEndFlag = (((omniORB.tcInternal.tv_string,0), ), (omniORB.tcInternal.tv_boolean, ), None)
Wordy._d_roundEndFlag = (((omniORB.tcInternal.tv_string,0), ), (omniORB.tcInternal.tv_boolean, ), None)

# Wordy object reference
class _objref_Wordy (CORBA.Object):
    _NP_RepositoryId = Wordy._NP_RepositoryId

    def __init__(self, obj):
        CORBA.Object.__init__(self, obj)

    def login(self, *args):
        return self._obj.invoke("login", _0_WordyModule.Wordy._d_login, args)

    def logout(self, *args):
        return self._obj.invoke("logout", _0_WordyModule.Wordy._d_logout, args)

    def initiateGame(self, *args):
        return self._obj.invoke("initiateGame", _0_WordyModule.Wordy._d_initiateGame, args)

    def submitWord(self, *args):
        return self._obj.invoke("submitWord", _0_WordyModule.Wordy._d_submitWord, args)

    def getGameWinner(self, *args):
        return self._obj.invoke("getGameWinner", _0_WordyModule.Wordy._d_getGameWinner, args)

    def getAllPlayers(self, *args):
        return self._obj.invoke("getAllPlayers", _0_WordyModule.Wordy._d_getAllPlayers, args)

    def getRoundWinner(self, *args):
        return self._obj.invoke("getRoundWinner", _0_WordyModule.Wordy._d_getRoundWinner, args)

    def getLetters(self, *args):
        return self._obj.invoke("getLetters", _0_WordyModule.Wordy._d_getLetters, args)

    def getTime(self, *args):
        return self._obj.invoke("getTime", _0_WordyModule.Wordy._d_getTime, args)

    def getLongestWord(self, *args):
        return self._obj.invoke("getLongestWord", _0_WordyModule.Wordy._d_getLongestWord, args)

    def getLongestWordsSize(self, *args):
        return self._obj.invoke("getLongestWordsSize", _0_WordyModule.Wordy._d_getLongestWordsSize, args)

    def getTopPlayers(self, *args):
        return self._obj.invoke("getTopPlayers", _0_WordyModule.Wordy._d_getTopPlayers, args)

    def getTopPlayersSize(self, *args):
        return self._obj.invoke("getTopPlayersSize", _0_WordyModule.Wordy._d_getTopPlayersSize, args)

    def disposeGame(self, *args):
        return self._obj.invoke("disposeGame", _0_WordyModule.Wordy._d_disposeGame, args)

    def gameStartFlag(self, *args):
        return self._obj.invoke("gameStartFlag", _0_WordyModule.Wordy._d_gameStartFlag, args)

    def gameEndFlag(self, *args):
        return self._obj.invoke("gameEndFlag", _0_WordyModule.Wordy._d_gameEndFlag, args)

    def roundEndFlag(self, *args):
        return self._obj.invoke("roundEndFlag", _0_WordyModule.Wordy._d_roundEndFlag, args)

omniORB.registerObjref(Wordy._NP_RepositoryId, _objref_Wordy)
_0_WordyModule._objref_Wordy = _objref_Wordy
del Wordy, _objref_Wordy

# Wordy skeleton
__name__ = "WordyModule__POA"
class Wordy (PortableServer.Servant):
    _NP_RepositoryId = _0_WordyModule.Wordy._NP_RepositoryId


    _omni_op_d = {"login": _0_WordyModule.Wordy._d_login, "logout": _0_WordyModule.Wordy._d_logout, "initiateGame": _0_WordyModule.Wordy._d_initiateGame, "submitWord": _0_WordyModule.Wordy._d_submitWord, "getGameWinner": _0_WordyModule.Wordy._d_getGameWinner, "getAllPlayers": _0_WordyModule.Wordy._d_getAllPlayers, "getRoundWinner": _0_WordyModule.Wordy._d_getRoundWinner, "getLetters": _0_WordyModule.Wordy._d_getLetters, "getTime": _0_WordyModule.Wordy._d_getTime, "getLongestWord": _0_WordyModule.Wordy._d_getLongestWord, "getLongestWordsSize": _0_WordyModule.Wordy._d_getLongestWordsSize, "getTopPlayers": _0_WordyModule.Wordy._d_getTopPlayers, "getTopPlayersSize": _0_WordyModule.Wordy._d_getTopPlayersSize, "disposeGame": _0_WordyModule.Wordy._d_disposeGame, "gameStartFlag": _0_WordyModule.Wordy._d_gameStartFlag, "gameEndFlag": _0_WordyModule.Wordy._d_gameEndFlag, "roundEndFlag": _0_WordyModule.Wordy._d_roundEndFlag}

Wordy._omni_skeleton = Wordy
_0_WordyModule__POA.Wordy = Wordy
omniORB.registerSkeleton(Wordy._NP_RepositoryId, Wordy)
del Wordy
__name__ = "WordyModule"

#
# End of module "WordyModule"
#
__name__ = "wordy_idl"

_exported_modules = ( "WordyModule", )

# The end.
